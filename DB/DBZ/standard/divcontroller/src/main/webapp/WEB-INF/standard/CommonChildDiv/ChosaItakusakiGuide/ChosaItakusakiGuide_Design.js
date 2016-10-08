var DBZ;
(function (DBZ) {
    (function (ChosaItakusakiGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnClear = function () {
                return "onClick_btnClear";
            };

            Events.onClick_btnKensaku = function () {
                return "onClick_btnKensaku";
            };

            Events.onSelect = function () {
                return "onSelect";
            };

            Events.onClick_btnModoru = function () {
                return "onClick_btnModoru";
            };
            return Events;
        })();
        ChosaItakusakiGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosaItakusakiGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChosaItakusakiGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChosaItakusakiGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosaItakusakiGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KensakuJoken = function () {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            };

            Controls.prototype.Hokensha = function () {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("Hokensha"));
            };

            Controls.prototype.txtChosaItakusakiCodeFrom = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakusakiCodeFrom"));
            };

            Controls.prototype.txtChosaItakuaskiCodeTo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtChosaItakuaskiCodeTo"));
            };

            Controls.prototype.radItakusakiJokyo = function () {
                return new UZA.RadioButton(this.convFiledName("radItakusakiJokyo"));
            };

            Controls.prototype.txtChosaItakusakiName = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiName"));
            };

            Controls.prototype.txtChosaItakusakiKanaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtChosaItakusakiKanaMeisho"));
            };

            Controls.prototype.ddlChosaItakusakiKubun = function () {
                return new UZA.DropDownList(this.convFiledName("ddlChosaItakusakiKubun"));
            };

            Controls.prototype.txtChikuCode = function () {
                return new UZA.TextBoxChikuCode(this.convFiledName("txtChikuCode"));
            };

            Controls.prototype.txtMaxKensu = function () {
                return new UZA.TextBoxNum(this.convFiledName("txtMaxKensu"));
            };

            Controls.prototype.btnClear = function () {
                return new UZA.Button(this.convFiledName("btnClear"));
            };

            Controls.prototype.btnKensaku = function () {
                return new UZA.Button(this.convFiledName("btnKensaku"));
            };

            Controls.prototype.KensakuKekkaIchiran = function () {
                return new UZA.Panel(this.convFiledName("KensakuKekkaIchiran"));
            };

            Controls.prototype.dgKensakuKekkaIchiran = function () {
                return new UZA.DataGrid(this.convFiledName("dgKensakuKekkaIchiran"));
            };

            Controls.prototype.btnBack = function () {
                return new UZA.Button(this.convFiledName("btnBack"));
            };
            return Controls;
        })();
        ChosaItakusakiGuide.Controls = Controls;
    })(DBZ.ChosaItakusakiGuide || (DBZ.ChosaItakusakiGuide = {}));
    var ChosaItakusakiGuide = DBZ.ChosaItakusakiGuide;
})(DBZ || (DBZ = {}));
