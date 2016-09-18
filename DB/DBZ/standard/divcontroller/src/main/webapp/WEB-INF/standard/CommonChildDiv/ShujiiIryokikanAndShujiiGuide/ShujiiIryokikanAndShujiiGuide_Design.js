var DBZ;
(function (DBZ) {
    (function (ShujiiIryokikanAndShujiiGuide) {
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
        ShujiiIryokikanAndShujiiGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShujiiIryokikanAndShujiiGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShujiiIryokikanAndShujiiGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShujiiIryokikanAndShujiiGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.KensakuJoken = function () {
                return new UZA.Panel(this.convFiledName("KensakuJoken"));
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

            Controls.prototype.txtShuijiiCodeFrom = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShuijiiCodeFrom"));
            };

            Controls.prototype.txtShujiiCodeTo = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtShujiiCodeTo"));
            };

            Controls.prototype.radShujiiJokyo = function () {
                return new UZA.RadioButton(this.convFiledName("radShujiiJokyo"));
            };

            Controls.prototype.txtShujiiShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiShimei"));
            };

            Controls.prototype.txtShujiiKanaShimei = function () {
                return new UZA.TextBox(this.convFiledName("txtShujiiKanaShimei"));
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
        ShujiiIryokikanAndShujiiGuide.Controls = Controls;
    })(DBZ.ShujiiIryokikanAndShujiiGuide || (DBZ.ShujiiIryokikanAndShujiiGuide = {}));
    var ShujiiIryokikanAndShujiiGuide = DBZ.ShujiiIryokikanAndShujiiGuide;
})(DBZ || (DBZ = {}));
