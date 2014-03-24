/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査項目に対する選択肢を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class Choice {

    /**
     * 「自由入力」を表す列挙型です。<br />
     * 調査結果を直接入力する場合に使用します。
     */
    public enum FreeInput implements IAnsweringItem {

        /**
         * 「自由入力」であることを表します。<br />
         * 値 : 1
         */
        自由入力("1");
        private RString value;

        private FreeInput(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「チェック有無」を表す列挙型です。<br />
     * 単純に調査結果の有無だけを指定する場合に使用します。
     */
    public enum Checked implements IAnsweringItem {

        /**
         * 「チェック無し」であることを表します。<br />
         * 値 : 1
         */
        無し("0"),
        /**
         * 「チェック有り」であることを表します。<br />
         * 値 : 2
         */
        有り("1");
        private RString value;

        private Checked(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「ない／ある」の選択肢を表す列挙型です。
     */
    public enum NaiAru implements IAnsweringItem {

        /**
         * 選択肢が「ない」であることを表します。<br />
         * 値 : 1
         */
        ない("1"),
        /**
         * 選択肢が「ある」であることを表します。<br />
         * 値 : 2
         */
        ある("2");
        private RString value;

        private NaiAru(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「ない／ある」の選択肢を表す列挙型です。
     */
    public enum NaiAru2 implements IAnsweringItem {

        /**
         * 選択肢が「ない」であることを表します。<br />
         * 値 : 1
         */
        ない("1"),
        /**
         * 選択肢が「ときどきある」であることを表します。<br />
         * 値 : 2
         */
        ときどきある("2"),
        /**
         * 選択肢が「ある」であることを表します。<br />
         * 値 : 3
         */
        ある("3");
        private RString value;

        private NaiAru2(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * 値 : 1
         */
        できる("1"),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * 値 : 2
         */
        できない("2");
        private RString value;

        private DekiruDekinai(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai2 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * 値 : 1
         */
        できる("1"),
        /**
         * 選択肢が「ときどきできる」であることを表します。<br />
         * 値 : 2
         */
        ときどきできる("2"),
        /**
         * 選択肢が「ほとんど不可」であることを表します。<br />
         * 値 : 3
         */
        ほとんど不可("3"),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * 値 : 4
         */
        できない("4");
        private RString value;

        private DekiruDekinai2(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai3 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * 値 : 1
         */
        できる("1"),
        /**
         * 選択肢が「つかまれば可」であることを表します。<br />
         * 値 : 2
         */
        つかまれば可("2"),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * 値 : 3
         */
        できない("3");
        private RString value;

        private DekiruDekinai3(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai4 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * 値 : 1
         */
        できる("1"),
        /**
         * 選択肢が「見守り等」であることを表します。<br />
         * 値 : 2
         */
        見守り等("2"),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * 値 : 3
         */
        できない("3");
        private RString value;

        private DekiruDekinai4(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai5 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * 値 : 1
         */
        できる("1"),
        /**
         * 選択肢が「支えが必要」であることを表します。<br />
         * 値 : 2
         */
        支えが必要("2"),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * 値 : 3
         */
        できない("3");
        private RString value;

        private DekiruDekinai5(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai6 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * 値 : 1
         */
        できる("1"),
        /**
         * 選択肢が「自分で支えれば可」であることを表します。<br />
         * 値 : 2
         */
        自分で支えれば可("2"),
        /**
         * 選択肢が「支えが必要」であることを表します。<br />
         * 値 : 3
         */
        支えが必要("3"),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * 値 : 4
         */
        できない("4");
        private RString value;

        private DekiruDekinai6(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai7 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * 値 : 1
         */
        できる("1"),
        /**
         * 選択肢が「特別な場合を除いてできる」であることを表します。<br />
         * 値 : 2
         */
        特別な場合を除いてできる("2"),
        /**
         * 選択肢が「日常的に困難」であることを表します。<br />
         * 値 : 3
         */
        日常的に困難("3"),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * 値 : 4
         */
        できない("4");
        private RString value;

        private DekiruDekinai7(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「介助」の選択肢を表す列挙型です。
     */
    public enum Kaijo implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * 値 : 1
         */
        自立("1"),
        /**
         * 選択肢が「一部介助」であることを表します。<br />
         * 値 : 2
         */
        一部介助("2"),
        /**
         * 選択肢が「全介助」であることを表します。<br />
         * 値 : 3
         */
        全介助("3");
        private RString value;

        private Kaijo(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「介助」の選択肢を表す列挙型です。
     */
    public enum Kaijo2 implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * 値 : 1
         */
        自立("1"),
        /**
         * 選択肢が「一部介助」であることを表します。<br />
         * 値 : 2
         */
        一部介助("2"),
        /**
         * 選択肢が「全介助」であることを表します。<br />
         * 値 : 3
         */
        全介助("3"),
        /**
         * 選択肢が「行っていない」であることを表します。<br />
         * 値 : 4
         */
        行っていない("4");
        private RString value;

        private Kaijo2(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「介助」の選択肢を表す列挙型です。
     */
    public enum Kaijo3 implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * 値 : 1
         */
        自立("1"),
        /**
         * 選択肢が「見守り等」であることを表します。<br />
         * 値 : 2
         */
        見守り等("2"),
        /**
         * 選択肢が「一部介助」であることを表します。<br />
         * 値 : 3
         */
        一部介助("3"),
        /**
         * 選択肢が「全介助」であることを表します。<br />
         * 値 : 4
         */
        全介助("4");
        private RString value;

        private Kaijo3(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「視力」の選択肢を表す列挙型です。
     */
    public enum Shiryoku implements IAnsweringItem {

        /**
         * 選択肢が「普通」であることを表します。<br />
         * 値 : 1
         */
        普通("1"),
        /**
         * 選択肢が「１ｍ先が見える」であることを表します。<br />
         * 値 : 2
         */
        一ｍ先が見える("2"),
        /**
         * 選択肢が「目の前が見える」であることを表します。<br />
         * 値 : 3
         */
        目の前が見える("3"),
        /**
         * 選択肢が「ほとんど見えず」であることを表します。<br />
         * 値 : 4
         */
        ほとんど見えず("4"),
        /**
         * 選択肢が「判断不能」であることを表します。<br />
         * 値 : 5
         */
        判断不能("5");
        private RString value;

        private Shiryoku(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「聴力」の選択肢を表す列挙型です。
     */
    public enum Choryoku implements IAnsweringItem {

        /**
         * 選択肢が「普通」であることを表します。<br />
         * 値 : 1
         */
        普通("1"),
        /**
         * 選択肢が「やっと聞こえる」であることを表します。<br />
         * 値 : 2
         */
        やっと聞こえる("2"),
        /**
         * 選択肢が「大声が聞こえる」であることを表します。<br />
         * 値 : 3
         */
        大声が聞こえる("3"),
        /**
         * 選択肢が「ほとんど聞こえず」であることを表します。<br />
         * 値 : 4
         */
        ほとんど聞こえず("4"),
        /**
         * 選択肢が「判断不能」であることを表します。<br />
         * 値 : 5
         */
        判断不能("5");
        private RString value;

        private Choryoku(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「外出頻度」の選択肢を表す列挙型です。
     */
    public enum Gaishutsu implements IAnsweringItem {

        /**
         * 選択肢が「週１回以上」であることを表します。<br />
         * 値 : 1
         */
        週１回以上("1"),
        /**
         * 選択肢が「月１回以上」であることを表します。<br />
         * 値 : 2
         */
        月１回以上("2"),
        /**
         * 選択肢が「月１回未満」であることを表します。<br />
         * 値 : 3
         */
        月１回未満("3");
        private RString value;

        private Gaishutsu(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「指示」の選択肢を表す列挙型です。
     */
    public enum Shiji implements IAnsweringItem {

        /**
         * 選択肢が「指示が通じる」であることを表します。<br />
         * 値 : 1
         */
        指示が通じる("1"),
        /**
         * 選択肢が「ときどき通じる」であることを表します。<br />
         * 値 : 2
         */
        ときどき通じる("2"),
        /**
         * 選択肢が「指示が通じない」であることを表します。<br />
         * 値 : 3
         */
        指示が通じない("3");
        private RString value;

        private Shiji(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「障害高齢者の日常生活自立度」の調査結果を表す列挙型です。
     */
    public enum ShogaiJiritsu implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * 値 : 1
         */
        自立("1"),
        /**
         * 選択肢が「Ｊ１」であることを表します。<br />
         * 値 : 2
         */
        Ｊ１("2"),
        /**
         * 選択肢が「Ｊ２」であることを表します。<br />
         * 値 : 3
         */
        Ｊ２("3"),
        /**
         * 選択肢が「Ａ１」であることを表します。<br />
         * 値 : 4
         */
        Ａ１("4"),
        /**
         * 選択肢が「Ａ２」であることを表します。<br />
         * 値 : 5
         */
        Ａ２("5"),
        /**
         * 選択肢が「Ｂ１」であることを表します。<br />
         * 値 : 6
         */
        Ｂ１("6"),
        /**
         * 選択肢が「Ｂ２」であることを表します。<br />
         * 値 : 7
         */
        Ｂ２("7"),
        /**
         * 選択肢が「Ｃ１」であることを表します。<br />
         * 値 : 8
         */
        Ｃ１("8"),
        /**
         * 選択肢が「Ｃ２」であることを表します。<br />
         * 値 : 9
         */
        Ｃ２("9");
        private RString value;

        private ShogaiJiritsu(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「認知症高齢者の日常生活自立度」の選択肢を表す列挙型です。
     */
    public enum NinchishoJiritsu implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * 値 : 1
         */
        自立("1"),
        /**
         * 選択肢が「Ⅰ」であることを表します。<br />
         * 値 : 2
         */
        Ⅰ("2"),
        /**
         * 選択肢が「Ⅱａ」であることを表します。<br />
         * 値 : 3
         */
        Ⅱａ("3"),
        /**
         * 選択肢が「Ⅱｂ」であることを表します。<br />
         * 値 : 4
         */
        Ⅱｂ("4"),
        /**
         * 選択肢が「Ⅲａ」であることを表します。<br />
         * 値 : 5
         */
        Ⅲａ("5"),
        /**
         * 選択肢が「Ⅲｂ」であることを表します。<br />
         * 値 : 6
         */
        Ⅲｂ("6"),
        /**
         * 選択肢が「Ⅳ」であることを表します。<br />
         * 値 : 7
         */
        Ⅳ("7"),
        /**
         * 選択肢が「Ｍ」であることを表します。<br />
         * 値 : 8
         */
        Ｍ("8"),
        /**
         * 選択肢が「記載なし」であることを表します。<br />
         * 値 : 9
         */
        記載なし("9");
        private RString value;

        private NinchishoJiritsu(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「サービス区分」の選択肢を表す列挙型です。
     */
    public enum ServiceKubun implements IAnsweringItem {

        /**
         * 選択肢が「予防」であることを表します。<br />
         * 値 : 1
         */
        予防("1"),
        /**
         * 選択肢が「介護」であることを表します。<br />
         * 値 : 2
         */
        介護("2"),
        /**
         * 選択肢が「なし」であることを表します。<br />
         * 値 : 9
         */
        なし("9");
        private RString value;

        private ServiceKubun(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「施設利用」の選択肢を表す列挙型です。
     */
    public enum ShisetsuRiyo implements IAnsweringItem {

        /**
         * 選択肢が「介護老人福祉施設」であることを表します。<br />
         * 値 : 1
         */
        介護老人福祉施設("1"),
        /**
         * 選択肢が「介護老人保健施設」であることを表します。<br />
         * 値 : 2
         */
        介護老人保健施設("2"),
        /**
         * 選択肢が「介護療養型医療施設」であることを表します。<br />
         * 値 : 3
         */
        介護療養型医療施設("3"),
        /**
         * 選択肢が「認知症対応型共同生活介護適用施設」であることを表します。<br />
         * 値 : 4
         */
        認知症対応型共同生活介護適用施設("4"),
        /**
         * 選択肢が「特定施設入居者生活介護適用施設」であることを表します。<br />
         * 値 : 5
         */
        特定施設入居者生活介護適用施設("5"),
        /**
         * 選択肢が「医療機関_医療保険適用療養病床」であることを表します。<br />
         * 値 : 6
         */
        医療機関_医療保険適用療養病床("6"),
        /**
         * 選択肢が「医療機関_医療保険適用療養病床」であることを表します。<br />
         * 値 : 7
         */
        医療機関_療養病床以外("7"),
        /**
         * 選択肢が「その他の施設」であることを表します。<br />
         * 値 : 8
         */
        その他の施設("8");
        private RString value;

        private ShisetsuRiyo(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * /**
     * 「安定性」の選択肢を表す列挙型です。
     */
    public enum Antei implements IAnsweringItem {

        /**
         * 選択肢が「安定」であることを表します。<br />
         * 値 : 1
         */
        安定("1"),
        /**
         * 選択肢が「不安定」であることを表します。<br />
         * 値 : 2
         */
        不安定("2"),
        /**
         * 選択肢が「不明」であることを表します。<br />
         * 値 : 3
         */
        不明("3");
        private RString value;

        private Antei(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「問題なし／問題あり」の選択肢を表す列挙型です。
     */
    public enum MondaiNashiAri implements IAnsweringItem {

        /**
         * 選択肢が「問題なし」であることを表します。<br />
         * 値 : 1
         */
        問題なし("1"),
        /**
         * 選択肢が「問題あり」であることを表します。<br />
         * 値 : 2
         */
        問題あり("2");
        private RString value;

        private MondaiNashiAri(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「認知能力」の選択肢を表す列挙型です。
     */
    public enum Ninchi implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * 値 : 1
         */
        自立("1"),
        /**
         * 選択肢が「いくらか困難」であることを表します。<br />
         * 値 : 2
         */
        いくらか困難("2"),
        /**
         * 選択肢が「見守りが必要」であることを表します。<br />
         * 値 : 3
         */
        見守りが必要("3"),
        /**
         * 選択肢が「判断できない」であることを表します。<br />
         * 値 : 4
         */
        判断できない("4");
        private RString value;

        private Ninchi(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「伝達能力」の選択肢を表す列挙型です。
     */
    public enum Dentatsu implements IAnsweringItem {

        /**
         * 選択肢が「伝えられる」であることを表します。<br />
         * 値 : 1
         */
        伝えられる("1"),
        /**
         * 選択肢が「いくらか困難」であることを表します。<br />
         * 値 : 2
         */
        いくらか困難("2"),
        /**
         * 選択肢が「具体的要求に限られる」であることを表します。<br />
         * 値 : 3
         */
        具体的要求に限られる("3"),
        /**
         * 選択肢が「伝えられない」であることを表します。<br />
         * 値 : 4
         */
        伝えられない("4");
        private RString value;

        private Dentatsu(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「なし／あり」の選択肢を表す列挙型です。
     */
    public enum NashiAri implements IAnsweringItem {

        /**
         * 選択肢が「無」であることを表します。<br />
         * 値 : 0
         */
        無("0"),
        /**
         * 選択肢が「有」であることを表します。<br />
         * 値 : 1
         */
        有("1");
        private RString value;

        private NashiAri(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「なし／あり」の選択肢を表す列挙型です。
     */
    public enum NashiAri2 implements IAnsweringItem {

        /**
         * 選択肢が「無」であることを表します。<br />
         * 値 : 0
         */
        無("0"),
        /**
         * 選択肢が「有」であることを表します。<br />
         * 値 : 1
         */
        有("1"),
        /**
         * 選択肢が「不明」であることを表します。<br />
         * 値 : 2
         */
        不明("2");
        private RString value;

        private NashiAri2(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「なし／あり」の選択肢を表す列挙型です。
     */
    public enum NashiAri3 implements IAnsweringItem {

        /**
         * 選択肢が「特になし」であることを表します。<br />
         * 値 : 0
         */
        特になし("0"),
        /**
         * 選択肢が「あり」であることを表します。<br />
         * 値 : 2
         */
        あり("1");
        private RString value;

        private NashiAri3(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「あり／なし」の選択肢を表す列挙型です。
     */
    public enum AriNashi implements IAnsweringItem {

        /**
         * 選択肢が「有」であることを表します。<br />
         * 値 : 1
         */
        有("1"),
        /**
         * 選択肢が「無」であることを表します。<br />
         * 値 : 0
         */
        無("0");
        private RString value;

        private AriNashi(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「右／左」の選択肢を表す列挙型です。
     */
    public enum MigiHidari implements IAnsweringItem {

        /**
         * 選択肢が「右」であることを表します。<br />
         * 値 : 1
         */
        右("1"),
        /**
         * 選択肢が「左」であることを表します。<br />
         * 値 : 2
         */
        左("2");
        private RString value;

        private MigiHidari(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「増加／減少」の選択肢を表す列挙型です。
     */
    public enum ZokaGensho implements IAnsweringItem {

        /**
         * 選択肢が「増加」であることを表します。<br />
         * 値 : 1
         */
        増加("1"),
        /**
         * 選択肢が「維持」であることを表します。<br />
         * 値 : 2
         */
        維持("2"),
        /**
         * 選択肢が「減少」であることを表します。<br />
         * 値 : 3
         */
        減少("3");
        private RString value;

        private ZokaGensho(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「程度」の選択肢を表す列挙型です。
     */
    public enum Teido implements IAnsweringItem {

        /**
         * 選択肢が「軽」であることを表します。<br />
         * 値 : 1
         */
        軽("1"),
        /**
         * 選択肢が「中」であることを表します。<br />
         * 値 : 2
         */
        中("2"),
        /**
         * 選択肢が「重」であることを表します。<br />
         * 値 : 3
         */
        重("3");
        private RString value;

        private Teido(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「介助」の選択肢を表す列挙型です。
     */
    public enum Kaijo4 implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * 値 : 1
         */
        自立("1"),
        /**
         * 選択肢が「介助があればしている」であることを表します。<br />
         * 値 : 2
         */
        介助があればしている("2"),
        /**
         * 選択肢が「していない」であることを表します。<br />
         * 値 : 3
         */
        していない("3");
        private RString value;

        private Kaijo4(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「車いすの使用」の選択肢を表す列挙型です。
     */
    public enum Kurumaisu implements IAnsweringItem {

        /**
         * 選択肢が「用いていない」であることを表します。<br />
         * 値 : 1
         */
        用いていない("1"),
        /**
         * 選択肢が「主に自分で操作している」であることを表します。<br />
         * 値 : 2
         */
        主に自分で操作している("2"),
        /**
         * 選択肢が「主に他人が操作している」であることを表します。<br />
         * 値 : 3
         */
        主に他人が操作している("3");
        private RString value;

        private Kurumaisu(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「食事行為」の選択肢を表す列挙型です。
     */
    public enum Shokuji implements IAnsweringItem {

        /**
         * 選択肢が「自立ないし何とか自分で食べられる」であることを表します。<br />
         * 値 : 1
         */
        自立ないし何とか自分で食べられる("1"),
        /**
         * 選択肢が「全面介助」であることを表します。<br />
         * 値 : 2
         */
        全面介助("2");
        private RString value;

        private Shokuji(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「状態」の選択肢を表す列挙型です。
     */
    public enum Jotai implements IAnsweringItem {

        /**
         * 選択肢が「良好」であることを表します。<br />
         * 値 : 1
         */
        良好("1"),
        /**
         * 選択肢が「不良」であることを表します。<br />
         * 値 : 2
         */
        不良("2");
        private RString value;

        private Jotai(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }

    /**
     * 「期待」の選択肢を表す列挙型です。
     */
    public enum Kitai implements IAnsweringItem {

        /**
         * 選択肢が「期待できる」であることを表します。<br />
         * 値 : 1
         */
        期待できる("1"),
        /**
         * 選択肢が「期待できない」であることを表します。<br />
         * 値 : 2
         */
        期待できない("2"),
        /**
         * 選択肢が「不明」であることを表します。<br />
         * 値 : 3
         */
        不明("3");
        private RString value;

        private Kitai(String value) {
            this.value = new RString(value);
        }

        @Override
        public RString getCode() {
            return value;
        }

        @Override
        public RString getValue() {
            return new RString(name());
        }
    }
}
