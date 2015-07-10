/// <reference path="../d.ts/jquery.d.ts" />
/// <reference path="../d.ts/UzViewControls.d.ts" />
/// <reference path="../d.ts/UzaConverter.d.ts" />

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

            public tblKiwariGaku(): UZA.TablePanel {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku"));
            }

            public celKiwarigaku1(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku1"));
            }

            public celKiwarigaku2(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku2"));
            }

            public lblTokucho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokucho"));
            }

            public celKiwarigaku3(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku3"));
            }

            public lblFucho(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFucho"));
            }

            public celKiwarigaku4(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku4"));
            }

            public lblTsuki(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki"));
            }

            public celKiwarigaku5(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku5"));
            }

            public lblTokuchoKi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi"));
            }

            public celKiwarigaku6(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku6"));
            }

            public lblTokuKibetsuGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku"));
            }

            public celKiwarigaku10(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku10"));
            }

            public lblTokuNofuGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku"));
            }

            public celKiwarigaku11(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku11"));
            }

            public lblFuchoKi(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi"));
            }

            public celKiwarigaku12(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku12"));
            }

            public lblFuchoKibetsuGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku"));
            }

            public celKiwarigaku13(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku13"));
            }

            public lblFuchoNofuGaku(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku"));
            }

            public celKiwarigaku7(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku7"));
            }

            public lblTsuki1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki1"));
            }

            public celKiwarigaku8(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku8"));
            }

            public lblTokuchoKi1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi1"));
            }

            public celKiwarigaku9(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku9"));
            }

            public lblTokuKibetsuGaku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku1"));
            }

            public celKiwarigaku17(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku17"));
            }

            public lblTokuNofuGaku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku1"));
            }

            public celKiwarigaku18(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku18"));
            }

            public lblFuchoKi1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi1"));
            }

            public celKiwarigaku19(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku19"));
            }

            public lblFuchoKibetsuGaku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku1"));
            }

            public celKiwarigaku20(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku20"));
            }

            public lblFuchoNofuGaku1(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku1"));
            }

            public celKiwarigaku24(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku24"));
            }

            public lblTsuki2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki2"));
            }

            public celKiwarigaku25(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku25"));
            }

            public celKiwarigaku26(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku26"));
            }

            public celKiwarigaku27(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku27"));
            }

            public celKiwarigaku28(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku28"));
            }

            public lblFuchoKi2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi2"));
            }

            public celKiwarigaku29(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku29"));
            }

            public lblFuchoKibetsuGaku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku2"));
            }

            public celKiwarigaku30(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku30"));
            }

            public lblFuchoNofuGaku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku2"));
            }

            public celKiwarigaku34(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku34"));
            }

            public lblTsuki3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki3"));
            }

            public celKiwarigaku35(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku35"));
            }

            public lblTokuchoKi2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi2"));
            }

            public celKiwarigaku36(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku36"));
            }

            public lblTokuKibetsuGaku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku2"));
            }

            public celKiwarigaku37(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku37"));
            }

            public lblTokuNofuGaku2(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku2"));
            }

            public celKiwarigaku38(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku38"));
            }

            public lblFuchoKi3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi3"));
            }

            public celKiwarigaku39(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku39"));
            }

            public lblFuchoKibetsuGaku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku3"));
            }

            public celKiwarigaku40(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku40"));
            }

            public lblFuchoNofuGaku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku3"));
            }

            public celKiwarigaku44(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku44"));
            }

            public lblTsuki4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki4"));
            }

            public celKiwarigaku45(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku45"));
            }

            public celKiwarigaku46(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku46"));
            }

            public celKiwarigaku47(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku47"));
            }

            public celKiwarigaku48(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku48"));
            }

            public lblFuchoKi4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi4"));
            }

            public celKiwarigaku49(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku49"));
            }

            public lblFuchoKibetsuGaku4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku4"));
            }

            public celKiwarigaku50(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku50"));
            }

            public lblFuchoNofuGaku4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku4"));
            }

            public celKiwarigaku54(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku54"));
            }

            public lblTsuki5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki5"));
            }

            public celKiwarigaku55(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku55"));
            }

            public lblTokuchoKi3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi3"));
            }

            public celKiwarigaku56(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku56"));
            }

            public lblTokuKibetsuGaku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku3"));
            }

            public celKiwarigaku57(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku57"));
            }

            public lblTokuNofuGaku3(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku3"));
            }

            public celKiwarigaku58(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku58"));
            }

            public lblFuchoKi5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi5"));
            }

            public celKiwarigaku59(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku59"));
            }

            public lblFuchoKibetsuGaku5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku5"));
            }

            public celKiwarigaku60(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku60"));
            }

            public lblFuchoNofuGaku5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku5"));
            }

            public celKiwarigaku64(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku64"));
            }

            public lblTsuki6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki6"));
            }

            public celKiwarigaku65(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku65"));
            }

            public celKiwarigaku66(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku66"));
            }

            public celKiwarigaku67(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku67"));
            }

            public celKiwarigaku68(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku68"));
            }

            public lblFuchoKi6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi6"));
            }

            public celKiwarigaku69(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku69"));
            }

            public lblFuchoKibetsuGaku6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku6"));
            }

            public celKiwarigaku70(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku70"));
            }

            public lblFuchoNofuGaku6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku6"));
            }

            public celKiwarigaku74(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku74"));
            }

            public lblTsuki7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki7"));
            }

            public celKiwarigaku75(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku75"));
            }

            public lblTokuchoKi4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi4"));
            }

            public celKiwarigaku76(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku76"));
            }

            public lblTokuKibetsuGaku4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku4"));
            }

            public celKiwarigaku77(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku77"));
            }

            public lblTokuNofuGaku4(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku4"));
            }

            public celKiwarigaku78(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku78"));
            }

            public lblFuchoKi7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi7"));
            }

            public celKiwarigaku79(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku79"));
            }

            public lblFuchoKibetsuGaku7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku7"));
            }

            public celKiwarigaku80(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku80"));
            }

            public lblFuchoNofuGaku7(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku7"));
            }

            public celKiwarigaku84(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku84"));
            }

            public lblTsuki8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki8"));
            }

            public celKiwarigaku85(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku85"));
            }

            public celKiwarigaku86(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku86"));
            }

            public celKiwarigaku87(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku87"));
            }

            public celKiwarigaku88(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku88"));
            }

            public lblFuchoKi8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi8"));
            }

            public celKiwarigaku89(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku89"));
            }

            public lblFuchoKibetsuGaku8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku8"));
            }

            public celKiwarigaku90(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku90"));
            }

            public lblFuchoNofuGaku8(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku8"));
            }

            public celKiwarigaku94(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku94"));
            }

            public lblTsuki9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki9"));
            }

            public celKiwarigaku95(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku95"));
            }

            public lblTokuchoKi5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi5"));
            }

            public celKiwarigaku96(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku96"));
            }

            public lblTokuKibetsuGaku5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku5"));
            }

            public celKiwarigaku97(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku97"));
            }

            public lblTokuNofuGaku5(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku5"));
            }

            public celKiwarigaku98(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku98"));
            }

            public lblFuchoKi9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi9"));
            }

            public celKiwarigaku99(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku99"));
            }

            public lblFuchoKibetsuGaku9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku9"));
            }

            public celKiwarigaku100(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku100"));
            }

            public lblFuchoNofuGaku9(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku9"));
            }

            public celKiwarigaku104(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku104"));
            }

            public lblTsuki10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki10"));
            }

            public celKiwarigaku105(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku105"));
            }

            public celKiwarigaku106(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku106"));
            }

            public celKiwarigaku107(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku107"));
            }

            public celKiwarigaku108(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku108"));
            }

            public lblFuchoKi10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi10"));
            }

            public celKiwarigaku109(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku109"));
            }

            public lblFuchoKibetsuGaku10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku10"));
            }

            public celKiwarigaku110(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku110"));
            }

            public lblFuchoNofuGaku10(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku10"));
            }

            public celKiwarigaku114(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku114"));
            }

            public lblTsuki11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki11"));
            }

            public celKiwarigaku115(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku115"));
            }

            public lblTokuchoKi6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuchoKi6"));
            }

            public celKiwarigaku116(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku116"));
            }

            public lblTokuKibetsuGaku6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku6"));
            }

            public celKiwarigaku117(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku117"));
            }

            public lblTokuNofuGaku6(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku6"));
            }

            public celKiwarigaku118(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku118"));
            }

            public lblFuchoKi11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi11"));
            }

            public celKiwarigaku119(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku119"));
            }

            public lblFuchoKibetsuGaku11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku11"));
            }

            public celKiwarigaku120(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku120"));
            }

            public lblFuchoNofuGaku11(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku11"));
            }

            public celKiwarigaku124(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku124"));
            }

            public lblTsuki12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki12"));
            }

            public celKiwarigaku125(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku125"));
            }

            public celKiwarigaku126(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku126"));
            }

            public celKiwarigaku127(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku127"));
            }

            public celKiwarigaku128(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku128"));
            }

            public lblFuchoKi12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi12"));
            }

            public celKiwarigaku129(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku129"));
            }

            public lblFuchoKibetsuGaku12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku12"));
            }

            public celKiwarigaku130(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku130"));
            }

            public lblFuchoNofuGaku12(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku12"));
            }

            public celKiwarigaku134(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku134"));
            }

            public lblTsuki13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki13"));
            }

            public celKiwarigaku135(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku135"));
            }

            public celKiwarigaku136(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku136"));
            }

            public celKiwarigaku137(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku137"));
            }

            public celKiwarigaku138(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku138"));
            }

            public lblFuchoKi13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi13"));
            }

            public celKiwarigaku139(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku139"));
            }

            public lblFuchoKibetsuGaku13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku13"));
            }

            public celKiwarigaku140(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku140"));
            }

            public lblFuchoNofuGaku13(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku13"));
            }

            public celKiwarigaku144(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku144"));
            }

            public lblTsuki14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki14"));
            }

            public celKiwarigaku145(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku145"));
            }

            public celKiwarigaku146(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku146"));
            }

            public celKiwarigaku147(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku147"));
            }

            public celKiwarigaku148(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku148"));
            }

            public lblFuchoKi14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKi14"));
            }

            public celKiwarigaku149(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku149"));
            }

            public lblFuchoKibetsuGaku14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku14"));
            }

            public celKiwarigaku150(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku150"));
            }

            public lblFuchoNofuGaku14(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku14"));
            }

            public celKiwarigaku154(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku154"));
            }

            public lblTsuki15(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTsuki15"));
            }

            public celKiwarigaku155(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku155"));
            }

            public celKiwarigaku156(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku156"));
            }

            public lblTokuKibetsuGakuKei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGakuKei"));
            }

            public celKiwarigaku157(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku157"));
            }

            public lblTokuNofuGakuKei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblTokuNofuGakuKei"));
            }

            public celKiwarigaku158(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku158"));
            }

            public celKiwarigaku159(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku159"));
            }

            public lblFuchoKibetsuGakuKei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGakuKei"));
            }

            public celKiwarigaku160(): UZA.TableCell {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku160"));
            }

            public lblFuchoNofuGakuKei(): UZA.Label {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGakuKei"));
            }

        }

     }

}

