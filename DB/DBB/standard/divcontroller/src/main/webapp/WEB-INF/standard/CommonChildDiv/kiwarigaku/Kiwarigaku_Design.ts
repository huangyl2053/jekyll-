/// <reference path="../../d.ts/jquery.d.ts" />
/// <reference path="../../d.ts/UzViewControls.d.ts" />
/// <reference path="../../d.ts/UzaConverter.d.ts" />

module DBB {

     export module Kiwarigaku {

        export class Events {

        }

        export class Controls {
            private _myName: string;

            public static myType(): string {
                return "Kiwarigaku";
            }

            constructor(fieldName: string) {
                this._myName = fieldName;
            }

            public convFiledNameSelf(): string {
                return this._myName + "_" + DBB.Kiwarigaku.Controls.myType();
            }

            public convFiledName(fieldName: string): string {
                return this._myName + "_" + DBB.Kiwarigaku.Controls.myType() + "_" + fieldName;
            }

            public Kiwarigaku(): UZA.Panel {
                return new UZA.Panel(this.convFiledNameSelf());
            }

            public tblTsuki1(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTsuki1"));
            }

            public celTsuki0(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki0"));
            }

            public lblTsuki0(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki0"));
            }

            public celTsuki(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki"));
            }

            public lblTsuki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki"));
            }

            public celTsuki1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki1"));
            }

            public lblTsuki1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki1"));
            }

            public celTsuki2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki2"));
            }

            public lblTsuki2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki2"));
            }

            public celTsuki3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki3"));
            }

            public lblTsuki3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki3"));
            }

            public celTsuki4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki4"));
            }

            public lblTsuki4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki4"));
            }

            public celTsuki5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki5"));
            }

            public lblTsuki5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki5"));
            }

            public celTsuki6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki6"));
            }

            public lblTsuki6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki6"));
            }

            public celTsuki7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki7"));
            }

            public lblTsuki7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki7"));
            }

            public celTsuki8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki8"));
            }

            public lblTsuki8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki8"));
            }

            public celTsuki9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki9"));
            }

            public lblTsuki9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki9"));
            }

            public celTsuki10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki10"));
            }

            public lblTsuki10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki10"));
            }

            public celTsuki11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki11"));
            }

            public lblTsuki11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki11"));
            }

            public celTsuki12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki12"));
            }

            public lblTsuki12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki12"));
            }

            public tblKiwariGaku1(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku1"));
            }

            public celTokucho(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokucho"));
            }

            public lblTokucho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokucho"));
            }

            public celFucho(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFucho"));
            }

            public lblFucho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFucho"));
            }

            public celTokuchoKi(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi"));
            }

            public lblTokuchoKi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi"));
            }

            public celTokuchoKibetsuGaku(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku"));
            }

            public lblTokuKibetsuGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku"));
            }

            public celTokuchoNofuGaku(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku"));
            }

            public lblTokuNofuGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku"));
            }

            public celFuchoKi(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi"));
            }

            public lblFuchoKi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi"));
            }

            public celFuchoKibetsuGaku(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku"));
            }

            public lblFuchoKibetsuGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku"));
            }

            public celFuchoNofuGaku(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku"));
            }

            public lblFuchoNofuGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku"));
            }

            public celTokuchoKi1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi1"));
            }

            public lblTokuchoKi1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi1"));
            }

            public celTokuchoKibetsuGaku1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku1"));
            }

            public lblTokuKibetsuGaku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku1"));
            }

            public celTokuchoNofuGaku1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku1"));
            }

            public lblTokuNofuGaku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku1"));
            }

            public celFuchoKi1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi1"));
            }

            public lblFuchoKi1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi1"));
            }

            public celFuchoKibetsuGaku1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku1"));
            }

            public lblFuchoKibetsuGaku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku1"));
            }

            public celFuchoNofuGaku1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku1"));
            }

            public lblFuchoNofuGaku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku1"));
            }

            public celTokuchoKi2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi2"));
            }

            public lblTokuchoKi2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi2"));
            }

            public celTokuchoKibetsuGaku2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku2"));
            }

            public lblTokuKibetsuGaku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku2"));
            }

            public celTokuchoNofuGaku2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku2"));
            }

            public lblTokuNofuGaku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku2"));
            }

            public celFuchoKi2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi2"));
            }

            public lblFuchoKi2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi2"));
            }

            public celFuchoKibetsuGaku2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku2"));
            }

            public lblFuchoKibetsuGaku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku2"));
            }

            public celFuchoNofuGaku2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku2"));
            }

            public lblFuchoNofuGaku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku2"));
            }

            public celTokuchoKi3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi3"));
            }

            public lblTokuchoKi3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi3"));
            }

            public celTokuchoKibetsuGaku3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku3"));
            }

            public lblTokuKibetsuGaku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku3"));
            }

            public celTokuchoNofuGaku3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku3"));
            }

            public lblTokuNofuGaku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku3"));
            }

            public celFuchoKi3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi3"));
            }

            public lblFuchoKi3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi3"));
            }

            public celFuchoKibetsuGaku3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku3"));
            }

            public lblFuchoKibetsuGaku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku3"));
            }

            public celFuchoNofuGaku3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku3"));
            }

            public lblFuchoNofuGaku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku3"));
            }

            public celTokuchoKi4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi4"));
            }

            public lblTokuchoKi4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi4"));
            }

            public celTokuchoKibetsuGaku4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku4"));
            }

            public lblTokuKibetsuGaku4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku4"));
            }

            public celTokuchoNofuGaku4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku4"));
            }

            public lblTokuNofuGaku4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku4"));
            }

            public celFuchoKi4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi4"));
            }

            public lblFuchoKi4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi4"));
            }

            public celFuchoKibetsuGaku4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku4"));
            }

            public lblFuchoKibetsuGaku4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku4"));
            }

            public celFuchoNofuGaku4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku4"));
            }

            public lblFuchoNofuGaku4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku4"));
            }

            public celTokuchoKi5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi5"));
            }

            public lblTokuchoKi5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi5"));
            }

            public celTokuchoKibetsuGaku5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku5"));
            }

            public lblTokuKibetsuGaku5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku5"));
            }

            public celTokuchoNofuGaku5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku5"));
            }

            public lblTokuNofuGaku5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku5"));
            }

            public celFuchoKi5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi5"));
            }

            public lblFuchoKi5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi5"));
            }

            public celFuchoKibetsuGaku5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku5"));
            }

            public lblFuchoKibetsuGaku5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku5"));
            }

            public celFuchoNofuGaku5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku5"));
            }

            public lblFuchoNofuGaku5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku5"));
            }

            public celTokuchoKi6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi6"));
            }

            public lblTokuchoKi6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi6"));
            }

            public celTokuchoKibetsuGaku6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku6"));
            }

            public lblTokuKibetsuGaku6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku6"));
            }

            public celTokuchoNofuGaku6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku6"));
            }

            public lblTokuNofuGaku6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku6"));
            }

            public celFuchoKi6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi6"));
            }

            public lblFuchoKi6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi6"));
            }

            public celFuchoKibetsuGaku6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku6"));
            }

            public lblFuchoKibetsuGaku6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku6"));
            }

            public celFuchoNofuGaku6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku6"));
            }

            public lblFuchoNofuGaku6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku6"));
            }

            public celTokuchoKi7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi7"));
            }

            public lblTokuchoKi7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi7"));
            }

            public celTokuchoKibetsuGaku7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku7"));
            }

            public lblTokuKibetsuGaku7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku7"));
            }

            public celTokuchoNofuGaku7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku7"));
            }

            public lblTokuNofuGaku7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku7"));
            }

            public celFuchoKi7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi7"));
            }

            public lblFuchoKi7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi7"));
            }

            public celFuchoKibetsuGaku7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku7"));
            }

            public lblFuchoKibetsuGaku7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku7"));
            }

            public celFuchoNofuGaku7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku7"));
            }

            public lblFuchoNofuGaku7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku7"));
            }

            public celTokuchoKi8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi8"));
            }

            public lblTokuchoKi8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi8"));
            }

            public celTokuchoKibetsuGaku8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku8"));
            }

            public lblTokuKibetsuGaku8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku8"));
            }

            public celTokuchoNofuGaku8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku8"));
            }

            public lblTokuNofuGaku8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku8"));
            }

            public celFuchoKi8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi8"));
            }

            public lblFuchoKi8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi8"));
            }

            public celFuchoKibetsuGaku8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku8"));
            }

            public lblFuchoKibetsuGaku8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku8"));
            }

            public celFuchoNofuGaku8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku8"));
            }

            public lblFuchoNofuGaku8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku8"));
            }

            public celTokuchoKi9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi9"));
            }

            public lblTokuchoKi9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi9"));
            }

            public celTokuchoKibetsuGaku9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku9"));
            }

            public lblTokuKibetsuGaku9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku9"));
            }

            public celTokuchoNofuGaku9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku9"));
            }

            public lblTokuNofuGaku9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku9"));
            }

            public celFuchoKi9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi9"));
            }

            public lblFuchoKi9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi9"));
            }

            public celFuchoKibetsuGaku9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku9"));
            }

            public lblFuchoKibetsuGaku9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku9"));
            }

            public celFuchoNofuGaku9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku9"));
            }

            public lblFuchoNofuGaku9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku9"));
            }

            public celTokuchoKi10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi10"));
            }

            public lblTokuchoKi10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi10"));
            }

            public celTokuchoKibetsuGaku10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku10"));
            }

            public lblTokuKibetsuGaku10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku10"));
            }

            public celTokuchoNofuGaku10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku10"));
            }

            public lblTokuNofuGaku10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku10"));
            }

            public celFuchoKi10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi10"));
            }

            public lblFuchoKi10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi10"));
            }

            public celFuchoKibetsuGaku10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku10"));
            }

            public lblFuchoKibetsuGaku10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku10"));
            }

            public celFuchoNofuGaku10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku10"));
            }

            public lblFuchoNofuGaku10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku10"));
            }

            public celTokuchoKi11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi11"));
            }

            public lblTokuchoKi11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi11"));
            }

            public celTokuchoKibetsuGaku11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku11"));
            }

            public lblTokuKibetsuGaku11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku11"));
            }

            public celTokuchoNofuGaku11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku11"));
            }

            public lblTokuNofuGaku11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku11"));
            }

            public celFuchoKi11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi11"));
            }

            public lblFuchoKi11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi11"));
            }

            public celFuchoKibetsuGaku11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku11"));
            }

            public lblFuchoKibetsuGaku11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku11"));
            }

            public celFuchoNofuGaku11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku11"));
            }

            public lblFuchoNofuGaku11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku11"));
            }

            public celTokuchoKi12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi12"));
            }

            public lblTokuchoKi12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi12"));
            }

            public celTokuchoKibetsuGaku12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku12"));
            }

            public lblTokuKibetsuGaku12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku12"));
            }

            public celTokuchoNofuGaku12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku12"));
            }

            public lblTokuNofuGaku12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku12"));
            }

            public celFuchoKi12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi12"));
            }

            public lblFuchoKi12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi12"));
            }

            public celFuchoKibetsuGaku12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku12"));
            }

            public lblFuchoKibetsuGaku12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku12"));
            }

            public celFuchoNofuGaku12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku12"));
            }

            public lblFuchoNofuGaku12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku12"));
            }

            public tblTsuki2(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTsuki2"));
            }

            public celTsuki13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki13"));
            }

            public lblTsuki13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki13"));
            }

            public tblKiwariGaku2(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku2"));
            }

            public celTokuchoKi13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi13"));
            }

            public lblTokuchoKi13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi13"));
            }

            public celTokuchoKibetsuGaku13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku13"));
            }

            public lblTokuKibetsuGaku13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku13"));
            }

            public celTokuchoNofuGaku13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku13"));
            }

            public lblTokuNofuGaku13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku13"));
            }

            public celFuchoKi13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi13"));
            }

            public lblFuchoKi13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi13"));
            }

            public celFuchoKibetsuGaku13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku13"));
            }

            public lblFuchoKibetsuGaku13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku13"));
            }

            public celFuchoNofuGaku13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku13"));
            }

            public lblFuchoNofuGaku13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku13"));
            }

            public tblTsuki3(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTsuki3"));
            }

            public celTsuki14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsuki14"));
            }

            public lblTsuki14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki14"));
            }

            public tblKiwariGaku3(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku3"));
            }

            public celTokuchoKi14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKi14"));
            }

            public lblTokuchoKi14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi14"));
            }

            public celTokuchoKibetsuGaku14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGaku14"));
            }

            public lblTokuKibetsuGaku14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku14"));
            }

            public celTokuchoNofuGaku14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGaku14"));
            }

            public lblTokuNofuGaku14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku14"));
            }

            public celFuchoKi14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKi14"));
            }

            public lblFuchoKi14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi14"));
            }

            public celFuchoKibetsuGaku14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGaku14"));
            }

            public lblFuchoKibetsuGaku14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku14"));
            }

            public celFuchoNofuGaku14(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGaku14"));
            }

            public lblFuchoNofuGaku14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku14"));
            }

            public tblTsuki4(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblTsuki4"));
            }

            public celTsukiGokei(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTsukiGokei"));
            }

            public lblTsukiGokei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsukiGokei"));
            }

            public tblKiwariGaku4(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku4"));
            }

            public celTokuchoKiGokei(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKiGokei"));
            }

            public lblTokuchoKiGokei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKiGokei"));
            }

            public celTokuchoKibetsuGakuGokei(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoKibetsuGakuGokei"));
            }

            public lblTokuKibetsuGakuGokei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGakuGokei"));
            }

            public celTokuchoNofuGakuGokei(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celTokuchoNofuGakuGokei"));
            }

            public lblTokuNofuGakuGokei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGakuGokei"));
            }

            public celFuchoKiGokei(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKiGokei"));
            }

            public lblFuchoKiGokei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKiGokei"));
            }

            public celFuchoKibetsuGakuGokei(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoKibetsuGakuGokei"));
            }

            public lblFuchoKibetsuGakuGokei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGakuGokei"));
            }

            public celFuchoNofuGakuGokei(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celFuchoNofuGakuGokei"));
            }

            public lblFuchoNofuGakuGokei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGakuGokei"));
            }

        }

     }

}

