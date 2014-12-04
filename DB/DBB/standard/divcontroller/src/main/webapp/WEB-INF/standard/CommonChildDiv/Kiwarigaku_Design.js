var DBB;
(function (DBB) {
    (function (Kiwarigaku) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        Kiwarigaku.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "Kiwarigaku";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBB.Kiwarigaku.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBB.Kiwarigaku.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.Kiwarigaku = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.tblKiwariGaku = function () {
                return new UZA.TablePanel(this.convFiledName("tblKiwariGaku"));
            };

            Controls.prototype.celKiwarigaku1 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku1"));
            };

            Controls.prototype.celKiwarigaku2 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku2"));
            };

            Controls.prototype.lblTokucho = function () {
                return new UZA.Label(this.convFiledName("lblTokucho"));
            };

            Controls.prototype.celKiwarigaku3 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku3"));
            };

            Controls.prototype.lblFucho = function () {
                return new UZA.Label(this.convFiledName("lblFucho"));
            };

            Controls.prototype.celKiwarigaku4 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku4"));
            };

            Controls.prototype.lblTsuki = function () {
                return new UZA.Label(this.convFiledName("lblTsuki"));
            };

            Controls.prototype.celKiwarigaku5 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku5"));
            };

            Controls.prototype.lblTokuchoKi = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi"));
            };

            Controls.prototype.celKiwarigaku6 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku6"));
            };

            Controls.prototype.lblTokuKibetsuGaku = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku"));
            };

            Controls.prototype.celKiwarigaku10 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku10"));
            };

            Controls.prototype.lblTokuNofuGaku = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku"));
            };

            Controls.prototype.celKiwarigaku11 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku11"));
            };

            Controls.prototype.lblFuchoKi = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi"));
            };

            Controls.prototype.celKiwarigaku12 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku12"));
            };

            Controls.prototype.lblFuchoKibetsuGaku = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku"));
            };

            Controls.prototype.celKiwarigaku13 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku13"));
            };

            Controls.prototype.lblFuchoNofuGaku = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku"));
            };

            Controls.prototype.celKiwarigaku7 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku7"));
            };

            Controls.prototype.lblTsuki1 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki1"));
            };

            Controls.prototype.celKiwarigaku8 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku8"));
            };

            Controls.prototype.lblTokuchoKi1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi1"));
            };

            Controls.prototype.celKiwarigaku9 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku9"));
            };

            Controls.prototype.lblTokuKibetsuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku1"));
            };

            Controls.prototype.celKiwarigaku17 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku17"));
            };

            Controls.prototype.lblTokuNofuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku1"));
            };

            Controls.prototype.celKiwarigaku18 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku18"));
            };

            Controls.prototype.lblFuchoKi1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi1"));
            };

            Controls.prototype.celKiwarigaku19 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku19"));
            };

            Controls.prototype.lblFuchoKibetsuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku1"));
            };

            Controls.prototype.celKiwarigaku20 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku20"));
            };

            Controls.prototype.lblFuchoNofuGaku1 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku1"));
            };

            Controls.prototype.celKiwarigaku24 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku24"));
            };

            Controls.prototype.lblTsuki2 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki2"));
            };

            Controls.prototype.celKiwarigaku25 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku25"));
            };

            Controls.prototype.celKiwarigaku26 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku26"));
            };

            Controls.prototype.celKiwarigaku27 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku27"));
            };

            Controls.prototype.celKiwarigaku28 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku28"));
            };

            Controls.prototype.lblFuchoKi2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi2"));
            };

            Controls.prototype.celKiwarigaku29 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku29"));
            };

            Controls.prototype.lblFuchoKibetsuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku2"));
            };

            Controls.prototype.celKiwarigaku30 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku30"));
            };

            Controls.prototype.lblFuchoNofuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku2"));
            };

            Controls.prototype.celKiwarigaku34 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku34"));
            };

            Controls.prototype.lblTsuki3 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki3"));
            };

            Controls.prototype.celKiwarigaku35 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku35"));
            };

            Controls.prototype.lblTokuchoKi2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi2"));
            };

            Controls.prototype.celKiwarigaku36 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku36"));
            };

            Controls.prototype.lblTokuKibetsuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku2"));
            };

            Controls.prototype.celKiwarigaku37 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku37"));
            };

            Controls.prototype.lblTokuNofuGaku2 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku2"));
            };

            Controls.prototype.celKiwarigaku38 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku38"));
            };

            Controls.prototype.lblFuchoKi3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi3"));
            };

            Controls.prototype.celKiwarigaku39 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku39"));
            };

            Controls.prototype.lblFuchoKibetsuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku3"));
            };

            Controls.prototype.celKiwarigaku40 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku40"));
            };

            Controls.prototype.lblFuchoNofuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku3"));
            };

            Controls.prototype.celKiwarigaku44 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku44"));
            };

            Controls.prototype.lblTsuki4 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki4"));
            };

            Controls.prototype.celKiwarigaku45 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku45"));
            };

            Controls.prototype.celKiwarigaku46 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku46"));
            };

            Controls.prototype.celKiwarigaku47 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku47"));
            };

            Controls.prototype.celKiwarigaku48 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku48"));
            };

            Controls.prototype.lblFuchoKi4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi4"));
            };

            Controls.prototype.celKiwarigaku49 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku49"));
            };

            Controls.prototype.lblFuchoKibetsuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku4"));
            };

            Controls.prototype.celKiwarigaku50 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku50"));
            };

            Controls.prototype.lblFuchoNofuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku4"));
            };

            Controls.prototype.celKiwarigaku54 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku54"));
            };

            Controls.prototype.lblTsuki5 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki5"));
            };

            Controls.prototype.celKiwarigaku55 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku55"));
            };

            Controls.prototype.lblTokuchoKi3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi3"));
            };

            Controls.prototype.celKiwarigaku56 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku56"));
            };

            Controls.prototype.lblTokuKibetsuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku3"));
            };

            Controls.prototype.celKiwarigaku57 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku57"));
            };

            Controls.prototype.lblTokuNofuGaku3 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku3"));
            };

            Controls.prototype.celKiwarigaku58 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku58"));
            };

            Controls.prototype.lblFuchoKi5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi5"));
            };

            Controls.prototype.celKiwarigaku59 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku59"));
            };

            Controls.prototype.lblFuchoKibetsuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku5"));
            };

            Controls.prototype.celKiwarigaku60 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku60"));
            };

            Controls.prototype.lblFuchoNofuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku5"));
            };

            Controls.prototype.celKiwarigaku64 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku64"));
            };

            Controls.prototype.lblTsuki6 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki6"));
            };

            Controls.prototype.celKiwarigaku65 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku65"));
            };

            Controls.prototype.celKiwarigaku66 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku66"));
            };

            Controls.prototype.celKiwarigaku67 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku67"));
            };

            Controls.prototype.celKiwarigaku68 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku68"));
            };

            Controls.prototype.lblFuchoKi6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi6"));
            };

            Controls.prototype.celKiwarigaku69 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku69"));
            };

            Controls.prototype.lblFuchoKibetsuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku6"));
            };

            Controls.prototype.celKiwarigaku70 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku70"));
            };

            Controls.prototype.lblFuchoNofuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku6"));
            };

            Controls.prototype.celKiwarigaku74 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku74"));
            };

            Controls.prototype.lblTsuki7 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki7"));
            };

            Controls.prototype.celKiwarigaku75 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku75"));
            };

            Controls.prototype.lblTokuchoKi4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi4"));
            };

            Controls.prototype.celKiwarigaku76 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku76"));
            };

            Controls.prototype.lblTokuKibetsuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku4"));
            };

            Controls.prototype.celKiwarigaku77 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku77"));
            };

            Controls.prototype.lblTokuNofuGaku4 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku4"));
            };

            Controls.prototype.celKiwarigaku78 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku78"));
            };

            Controls.prototype.lblFuchoKi7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi7"));
            };

            Controls.prototype.celKiwarigaku79 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku79"));
            };

            Controls.prototype.lblFuchoKibetsuGaku7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku7"));
            };

            Controls.prototype.celKiwarigaku80 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku80"));
            };

            Controls.prototype.lblFuchoNofuGaku7 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku7"));
            };

            Controls.prototype.celKiwarigaku84 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku84"));
            };

            Controls.prototype.lblTsuki8 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki8"));
            };

            Controls.prototype.celKiwarigaku85 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku85"));
            };

            Controls.prototype.celKiwarigaku86 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku86"));
            };

            Controls.prototype.celKiwarigaku87 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku87"));
            };

            Controls.prototype.celKiwarigaku88 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku88"));
            };

            Controls.prototype.lblFuchoKi8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi8"));
            };

            Controls.prototype.celKiwarigaku89 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku89"));
            };

            Controls.prototype.lblFuchoKibetsuGaku8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku8"));
            };

            Controls.prototype.celKiwarigaku90 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku90"));
            };

            Controls.prototype.lblFuchoNofuGaku8 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku8"));
            };

            Controls.prototype.celKiwarigaku94 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku94"));
            };

            Controls.prototype.lblTsuki9 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki9"));
            };

            Controls.prototype.celKiwarigaku95 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku95"));
            };

            Controls.prototype.lblTokuchoKi5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi5"));
            };

            Controls.prototype.celKiwarigaku96 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku96"));
            };

            Controls.prototype.lblTokuKibetsuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku5"));
            };

            Controls.prototype.celKiwarigaku97 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku97"));
            };

            Controls.prototype.lblTokuNofuGaku5 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku5"));
            };

            Controls.prototype.celKiwarigaku98 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku98"));
            };

            Controls.prototype.lblFuchoKi9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi9"));
            };

            Controls.prototype.celKiwarigaku99 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku99"));
            };

            Controls.prototype.lblFuchoKibetsuGaku9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku9"));
            };

            Controls.prototype.celKiwarigaku100 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku100"));
            };

            Controls.prototype.lblFuchoNofuGaku9 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku9"));
            };

            Controls.prototype.celKiwarigaku104 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku104"));
            };

            Controls.prototype.lblTsuki10 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki10"));
            };

            Controls.prototype.celKiwarigaku105 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku105"));
            };

            Controls.prototype.celKiwarigaku106 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku106"));
            };

            Controls.prototype.celKiwarigaku107 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku107"));
            };

            Controls.prototype.celKiwarigaku108 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku108"));
            };

            Controls.prototype.lblFuchoKi10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi10"));
            };

            Controls.prototype.celKiwarigaku109 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku109"));
            };

            Controls.prototype.lblFuchoKibetsuGaku10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku10"));
            };

            Controls.prototype.celKiwarigaku110 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku110"));
            };

            Controls.prototype.lblFuchoNofuGaku10 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku10"));
            };

            Controls.prototype.celKiwarigaku114 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku114"));
            };

            Controls.prototype.lblTsuki11 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki11"));
            };

            Controls.prototype.celKiwarigaku115 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku115"));
            };

            Controls.prototype.lblTokuchoKi6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuchoKi6"));
            };

            Controls.prototype.celKiwarigaku116 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku116"));
            };

            Controls.prototype.lblTokuKibetsuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGaku6"));
            };

            Controls.prototype.celKiwarigaku117 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku117"));
            };

            Controls.prototype.lblTokuNofuGaku6 = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGaku6"));
            };

            Controls.prototype.celKiwarigaku118 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku118"));
            };

            Controls.prototype.lblFuchoKi11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi11"));
            };

            Controls.prototype.celKiwarigaku119 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku119"));
            };

            Controls.prototype.lblFuchoKibetsuGaku11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku11"));
            };

            Controls.prototype.celKiwarigaku120 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku120"));
            };

            Controls.prototype.lblFuchoNofuGaku11 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku11"));
            };

            Controls.prototype.celKiwarigaku124 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku124"));
            };

            Controls.prototype.lblTsuki12 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki12"));
            };

            Controls.prototype.celKiwarigaku125 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku125"));
            };

            Controls.prototype.celKiwarigaku126 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku126"));
            };

            Controls.prototype.celKiwarigaku127 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku127"));
            };

            Controls.prototype.celKiwarigaku128 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku128"));
            };

            Controls.prototype.lblFuchoKi12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi12"));
            };

            Controls.prototype.celKiwarigaku129 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku129"));
            };

            Controls.prototype.lblFuchoKibetsuGaku12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku12"));
            };

            Controls.prototype.celKiwarigaku130 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku130"));
            };

            Controls.prototype.lblFuchoNofuGaku12 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku12"));
            };

            Controls.prototype.celKiwarigaku134 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku134"));
            };

            Controls.prototype.lblTsuki13 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki13"));
            };

            Controls.prototype.celKiwarigaku135 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku135"));
            };

            Controls.prototype.celKiwarigaku136 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku136"));
            };

            Controls.prototype.celKiwarigaku137 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku137"));
            };

            Controls.prototype.celKiwarigaku138 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku138"));
            };

            Controls.prototype.lblFuchoKi13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi13"));
            };

            Controls.prototype.celKiwarigaku139 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku139"));
            };

            Controls.prototype.lblFuchoKibetsuGaku13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku13"));
            };

            Controls.prototype.celKiwarigaku140 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku140"));
            };

            Controls.prototype.lblFuchoNofuGaku13 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku13"));
            };

            Controls.prototype.celKiwarigaku144 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku144"));
            };

            Controls.prototype.lblTsuki14 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki14"));
            };

            Controls.prototype.celKiwarigaku145 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku145"));
            };

            Controls.prototype.celKiwarigaku146 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku146"));
            };

            Controls.prototype.celKiwarigaku147 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku147"));
            };

            Controls.prototype.celKiwarigaku148 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku148"));
            };

            Controls.prototype.lblFuchoKi14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKi14"));
            };

            Controls.prototype.celKiwarigaku149 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku149"));
            };

            Controls.prototype.lblFuchoKibetsuGaku14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGaku14"));
            };

            Controls.prototype.celKiwarigaku150 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku150"));
            };

            Controls.prototype.lblFuchoNofuGaku14 = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGaku14"));
            };

            Controls.prototype.celKiwarigaku154 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku154"));
            };

            Controls.prototype.lblTsuki15 = function () {
                return new UZA.Label(this.convFiledName("lblTsuki15"));
            };

            Controls.prototype.celKiwarigaku155 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku155"));
            };

            Controls.prototype.celKiwarigaku156 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku156"));
            };

            Controls.prototype.lblTokuKibetsuGakuKei = function () {
                return new UZA.Label(this.convFiledName("lblTokuKibetsuGakuKei"));
            };

            Controls.prototype.celKiwarigaku157 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku157"));
            };

            Controls.prototype.lblTokuNofuGakuKei = function () {
                return new UZA.Label(this.convFiledName("lblTokuNofuGakuKei"));
            };

            Controls.prototype.celKiwarigaku158 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku158"));
            };

            Controls.prototype.celKiwarigaku159 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku159"));
            };

            Controls.prototype.lblFuchoKibetsuGakuKei = function () {
                return new UZA.Label(this.convFiledName("lblFuchoKibetsuGakuKei"));
            };

            Controls.prototype.celKiwarigaku160 = function () {
                return new UZA.TableCell(this.convFiledName("celKiwarigaku160"));
            };

            Controls.prototype.lblFuchoNofuGakuKei = function () {
                return new UZA.Label(this.convFiledName("lblFuchoNofuGakuKei"));
            };
            return Controls;
        })();
        Kiwarigaku.Controls = Controls;
    })(DBB.Kiwarigaku || (DBB.Kiwarigaku = {}));
    var Kiwarigaku = DBB.Kiwarigaku;
})(DBB || (DBB = {}));
