let isDeleteButtonActive = false;

function enableDeleteSection() {
    let deleteSectionList = document.querySelectorAll('#delete-btn')
    if(!isDeleteButtonActive) {
        revealSection(deleteSectionList);
        isDeleteButtonActive = setButtonActive();
    } else {
        hideSection(deleteSectionList);
        isDeleteButtonActive = setButtonPassive();
    }

}

function revealSection(sectionList) {
    sectionList.forEach(selection => (selection.style.display = "block"));
}

function hideSection(sectionList) {
    sectionList.forEach(selection => (selection.style.display = "none"));
}

function setButtonActive() {
    document.querySelector('#delete-link').style.color = '#00FF7F';
    return isDeleteButtonActive = true;
}

function setButtonPassive() {
    document.querySelector('#delete-link').style.color = '#A52A2A';
    return isDeleteButtonActive = false;
}