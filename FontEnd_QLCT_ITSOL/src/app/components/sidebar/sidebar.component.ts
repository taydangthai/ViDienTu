import { Component, OnInit } from '@angular/core';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/home', title: 'Trang Chủ',  icon: 'dashboard', class: '' },
    /*{ path: '/user-profile', title: 'Thành Viên',  icon:'person', class: '' },*/
    { path: '/wallet', title: 'Ví Của Bạn',  icon:'payments', class: '' },
    { path: '/transactions', title: 'Giao Dịch',  icon:'library_books', class: '' },
    { path: '/category', title: 'Danh Mục',  icon:'content_paste', class: '' },
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor() { }

  ngOnInit() {
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  };
}
