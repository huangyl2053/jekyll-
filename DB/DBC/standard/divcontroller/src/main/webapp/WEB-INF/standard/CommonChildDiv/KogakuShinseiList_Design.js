var DBC;
(function (DBC) {
    (function (KogakuShinseiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onMulti_dgKyufuJissekiMeisaiList = function () {
                return "onMulti_dgKyufuJissekiMeisaiList";
            };
            return Events;
        })();
        KogakuShinseiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "KogakuShinseiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.KogakuShinseiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.KogakuShinseiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.KogakuShinseiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtServiceYM = function () {
                return new UZA.TextBoxYearMonth(this.convFiledName("txtServiceYM"));
            };

            Controls.prototype.txtShokisai = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShokisai"));
            };

            Controls.prototype.btnShinseiJohoTsuika = function () {
                return new UZA.Button(this.convFiledName("btnShinseiJohoTsuika"));
            };

            Controls.prototype.btnTaishosyaJoho = function () {
                return new UZA.Button(this.convFiledName("btnTaishosyaJoho"));
            };

            Controls.prototype.lin1 = function () {
                return new UZA.HorizontalLine(this.convFiledName("lin1"));
            };

            Controls.prototype.txtServiceYMFrom = function () {
                return new UZA.TextBoxYearMonth(this.convFiledName("txtServiceYMFrom"));
            };

            Controls.prototype.txtServiceYMTo = function () {
                return new UZA.TextBoxYearMonth(this.convFiledName("txtServiceYMTo"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.dgShinseiJoho = function () {
                return new UZA.DataGrid(this.convFiledName("dgShinseiJoho"));
            };
            return Controls;
        })();
        KogakuShinseiList.Controls = Controls;
    })(DBC.KogakuShinseiList || (DBC.KogakuShinseiList = {}));
    var KogakuShinseiList = DBC.KogakuShinseiList;
})(DBC || (DBC = {}));
