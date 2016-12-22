var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanGuide) {
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
        ShujiiIryokikanGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShujiiIryokikanGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShujiiIryokikanGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShujiiIryokikanGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShujiiIryokikanGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KensakuJoken = function () {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
            };

            Controls.prototype.HokenshaList = function () {
                return new DBZ.HokenshaList.ModeController(this.convFiledName("HokenshaList"));
            };

            Controls.prototype.txtIryoKikanCodeFrom = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCodeFrom"));
            };

            Controls.prototype.txtIryoKikanCodeTo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtIryoKikanCodeTo"));
            };

            Controls.prototype.radIryoKikanJokyo = function () {
                return new UZA.RadioButton(this.convFiledName("radIryoKikanJokyo"));
            };

            Controls.prototype.txtIryoKikanName = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanName"));
            };

            Controls.prototype.txtIryoKikanKanaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtIryoKikanKanaMeisho"));
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
        ShujiiIryokikanGuide.Controls = Controls;
    })(DBZ.ShujiiIryokikanGuide || (DBZ.ShujiiIryokikanGuide = {}));
    var ShujiiIryokikanGuide = DBZ.ShujiiIryokikanGuide;
})(DBZ || (DBZ = {}));
