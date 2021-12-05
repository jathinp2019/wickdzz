const navToggle = document.querySelector(".mobile-nav-toggle");
const nav = document.querySelector(".primary-navigation");

navToggle.addEventListener("click", () => {
  const visibility = nav.getAttribute("data-visible");

  if (visibility === "false") {
    nav.setAttribute("data-visible", true);
    navToggle.ariaExpanded = "true";
  } else {
    nav.setAttribute("data-visible", false);
    navToggle.ariaExpanded = "false";
  }

  //   console.log(visibility);
});
