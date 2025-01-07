/**
 * 
 */
// Toggle dropdown menu on click
document.addEventListener('DOMContentLoaded', function () {
    const dropdownBtn = document.querySelector('.dropdown .dropbtn');
    const dropdownContent = document.getElementById('dropdown-content');

    // Toggle the dropdown content on button click
    dropdownBtn.addEventListener('click', function () {
        dropdownContent.classList.toggle('show');
    });

    // Close the dropdown if the user clicks outside of it
    window.addEventListener('click', function (e) {
        if (!dropdownBtn.contains(e.target) && !dropdownContent.contains(e.target)) {
            dropdownContent.classList.remove('show');
        }
    });
});
