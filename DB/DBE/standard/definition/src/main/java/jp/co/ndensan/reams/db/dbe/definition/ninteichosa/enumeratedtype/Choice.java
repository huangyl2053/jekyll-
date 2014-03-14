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
         * コード : 1
         */
        自由入力(1);
        private int code;

        private FreeInput(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
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
         * コード : 1
         */
        無し(1),
        /**
         * 「チェック有り」であることを表します。<br />
         * コード : 2
         */
        有り(2);
        private int code;

        private Checked(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「ない／ある」の選択肢を表す列挙型です。
     */
    public enum NaiAru implements IAnsweringItem {

        /**
         * 選択肢が「ない」であることを表します。<br />
         * コード : 1
         */
        ない(1),
        /**
         * 選択肢が「ある」であることを表します。<br />
         * コード : 2
         */
        ある(2);
        private int code;

        private NaiAru(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「ない／ある」の選択肢を表す列挙型です。
     */
    public enum NaiAru2 implements IAnsweringItem {

        /**
         * 選択肢が「ない」であることを表します。<br />
         * コード : 1
         */
        ない(1),
        /**
         * 選択肢が「ときどきある」であることを表します。<br />
         * コード : 2
         */
        ときどきある(2),
        /**
         * 選択肢が「ある」であることを表します。<br />
         * コード : 3
         */
        ある(3);
        private int code;

        private NaiAru2(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * コード : 1
         */
        できる(1),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * コード : 2
         */
        できない(2);
        private int code;

        private DekiruDekinai(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai2 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * コード : 1
         */
        できる(1),
        /**
         * 選択肢が「ときどきできる」であることを表します。<br />
         * コード : 2
         */
        ときどきできる(2),
        /**
         * 選択肢が「ほとんど不可」であることを表します。<br />
         * コード : 3
         */
        ほとんど不可(3),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * コード : 4
         */
        できない(4);
        private int code;

        private DekiruDekinai2(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai3 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * コード : 1
         */
        できる(1),
        /**
         * 選択肢が「つかまれば可」であることを表します。<br />
         * コード : 2
         */
        つかまれば可(2),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * コード : 3
         */
        できない(3);
        private int code;

        private DekiruDekinai3(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai4 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * コード : 1
         */
        できる(1),
        /**
         * 選択肢が「見守り等」であることを表します。<br />
         * コード : 2
         */
        見守り等(2),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * コード : 3
         */
        できない(3);
        private int code;

        private DekiruDekinai4(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai5 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * コード : 1
         */
        できる(1),
        /**
         * 選択肢が「支えが必要」であることを表します。<br />
         * コード : 2
         */
        支えが必要(2),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * コード : 3
         */
        できない(3);
        private int code;

        private DekiruDekinai5(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai6 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * コード : 1
         */
        できる(1),
        /**
         * 選択肢が「自分で支えれば可」であることを表します。<br />
         * コード : 2
         */
        自分で支えれば可(2),
        /**
         * 選択肢が「支えが必要」であることを表します。<br />
         * コード : 3
         */
        支えが必要(3),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * コード : 4
         */
        できない(4);
        private int code;

        private DekiruDekinai6(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「できる／できない」の選択肢を表す列挙型です。
     */
    public enum DekiruDekinai7 implements IAnsweringItem {

        /**
         * 選択肢が「できる」であることを表します。<br />
         * コード : 1
         */
        できる(1),
        /**
         * 選択肢が「特別な場合を除いてできる」であることを表します。<br />
         * コード : 2
         */
        特別な場合を除いてできる(2),
        /**
         * 選択肢が「日常的に困難」であることを表します。<br />
         * コード : 3
         */
        日常的に困難(3),
        /**
         * 選択肢が「できない」であることを表します。<br />
         * コード : 4
         */
        できない(4);
        private int code;

        private DekiruDekinai7(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「介助」の選択肢を表す列挙型です。
     */
    public enum Kaijo implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * コード : 1
         */
        自立(1),
        /**
         * 選択肢が「一部介助」であることを表します。<br />
         * コード : 2
         */
        一部介助(2),
        /**
         * 選択肢が「全介助」であることを表します。<br />
         * コード : 3
         */
        全介助(3);
        private int code;

        private Kaijo(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「介助」の選択肢を表す列挙型です。
     */
    public enum Kaijo2 implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * コード : 1
         */
        自立(1),
        /**
         * 選択肢が「一部介助」であることを表します。<br />
         * コード : 2
         */
        一部介助(2),
        /**
         * 選択肢が「全介助」であることを表します。<br />
         * コード : 3
         */
        全介助(3),
        /**
         * 選択肢が「行っていない」であることを表します。<br />
         * コード : 4
         */
        行っていない(4);
        private int code;

        private Kaijo2(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「介助」の選択肢を表す列挙型です。
     */
    public enum Kaijo3 implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * コード : 1
         */
        自立(1),
        /**
         * 選択肢が「見守り等」であることを表します。<br />
         * コード : 2
         */
        見守り等(2),
        /**
         * 選択肢が「一部介助」であることを表します。<br />
         * コード : 3
         */
        一部介助(3),
        /**
         * 選択肢が「全介助」であることを表します。<br />
         * コード : 4
         */
        全介助(4);
        private int code;

        private Kaijo3(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「視力」の選択肢を表す列挙型です。
     */
    public enum Shiryoku implements IAnsweringItem {

        /**
         * 選択肢が「普通」であることを表します。<br />
         * コード : 1
         */
        普通(1),
        /**
         * 選択肢が「１ｍ先が見える」であることを表します。<br />
         * コード : 2
         */
        一ｍ先が見える(2),
        /**
         * 選択肢が「目の前が見える」であることを表します。<br />
         * コード : 3
         */
        目の前が見える(3),
        /**
         * 選択肢が「ほとんど見えず」であることを表します。<br />
         * コード : 4
         */
        ほとんど見えず(4),
        /**
         * 選択肢が「判断不能」であることを表します。<br />
         * コード : 5
         */
        判断不能(5);
        private int code;

        private Shiryoku(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「聴力」の選択肢を表す列挙型です。
     */
    public enum Choryoku implements IAnsweringItem {

        /**
         * 選択肢が「普通」であることを表します。<br />
         * コード : 1
         */
        普通(1),
        /**
         * 選択肢が「やっと聞こえる」であることを表します。<br />
         * コード : 2
         */
        やっと聞こえる(2),
        /**
         * 選択肢が「大声が聞こえる」であることを表します。<br />
         * コード : 3
         */
        大声が聞こえる(3),
        /**
         * 選択肢が「ほとんど聞こえず」であることを表します。<br />
         * コード : 4
         */
        ほとんど聞こえず(4),
        /**
         * 選択肢が「判断不能」であることを表します。<br />
         * コード : 5
         */
        判断不能(5);
        private int code;

        private Choryoku(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「外出頻度」の選択肢を表す列挙型です。
     */
    public enum Gaishutsu implements IAnsweringItem {

        /**
         * 選択肢が「週１回以上」であることを表します。<br />
         * コード : 1
         */
        週１回以上(1),
        /**
         * 選択肢が「月１回以上」であることを表します。<br />
         * コード : 2
         */
        月１回以上(2),
        /**
         * 選択肢が「月１回未満」であることを表します。<br />
         * コード : 3
         */
        月１回未満(3);
        private int code;

        private Gaishutsu(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「指示」の選択肢を表す列挙型です。
     */
    public enum Shiji implements IAnsweringItem {

        /**
         * 選択肢が「指示が通じる」であることを表します。<br />
         * コード : 1
         */
        指示が通じる(1),
        /**
         * 選択肢が「ときどき通じる」であることを表します。<br />
         * コード : 2
         */
        ときどき通じる(2),
        /**
         * 選択肢が「指示が通じない」であることを表します。<br />
         * コード : 3
         */
        指示が通じない(3);
        private int code;

        private Shiji(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「障害高齢者の日常生活自立度」の調査結果を表す列挙型です。
     */
    public enum ShogaiJiritsu implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * コード : 1
         */
        自立(1),
        /**
         * 選択肢が「Ｊ１」であることを表します。<br />
         * コード : 2
         */
        Ｊ１(2),
        /**
         * 選択肢が「Ｊ２」であることを表します。<br />
         * コード : 3
         */
        Ｊ２(3),
        /**
         * 選択肢が「Ａ１」であることを表します。<br />
         * コード : 4
         */
        Ａ１(4),
        /**
         * 選択肢が「Ａ２」であることを表します。<br />
         * コード : 5
         */
        Ａ２(5),
        /**
         * 選択肢が「Ｂ１」であることを表します。<br />
         * コード : 6
         */
        Ｂ１(6),
        /**
         * 選択肢が「Ｂ２」であることを表します。<br />
         * コード : 7
         */
        Ｂ２(7),
        /**
         * 選択肢が「Ｃ１」であることを表します。<br />
         * コード : 8
         */
        Ｃ１(8),
        /**
         * 選択肢が「Ｃ２」であることを表します。<br />
         * コード : 9
         */
        Ｃ２(9);
        private int code;

        private ShogaiJiritsu(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「認知症高齢者の日常生活自立度」の選択肢を表す列挙型です。
     */
    public enum NinchishoJiritsu implements IAnsweringItem {

        /**
         * 選択肢が「自立」であることを表します。<br />
         * コード : 1
         */
        自立(1),
        /**
         * 選択肢が「Ⅰ」であることを表します。<br />
         * コード : 2
         */
        Ⅰ(2),
        /**
         * 選択肢が「Ⅱａ」であることを表します。<br />
         * コード : 3
         */
        Ⅱａ(3),
        /**
         * 選択肢が「Ⅱｂ」であることを表します。<br />
         * コード : 4
         */
        Ⅱｂ(4),
        /**
         * 選択肢が「Ⅲａ」であることを表します。<br />
         * コード : 5
         */
        Ⅲａ(5),
        /**
         * 選択肢が「Ⅲｂ」であることを表します。<br />
         * コード : 6
         */
        Ⅲｂ(6),
        /**
         * 選択肢が「Ⅳ」であることを表します。<br />
         * コード : 7
         */
        Ⅳ(7),
        /**
         * 選択肢が「Ｍ」であることを表します。<br />
         * コード : 8
         */
        Ｍ(8),
        /**
         * 選択肢が「記載なし」であることを表します。<br />
         * コード : 9
         */
        記載なし(9);
        private int code;

        private NinchishoJiritsu(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「サービス区分」の選択肢を表す列挙型です。
     */
    public enum ServiceKubun implements IAnsweringItem {

        /**
         * 選択肢が「予防」であることを表します。<br />
         * コード : 1
         */
        予防(1),
        /**
         * 選択肢が「介護」であることを表します。<br />
         * コード : 2
         */
        介護(2),
        /**
         * 選択肢が「なし」であることを表します。<br />
         * コード : 9
         */
        なし(9);
        private int code;

        private ServiceKubun(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }

    /**
     * 「施設利用」の選択肢を表す列挙型です。
     */
    public enum ShisetsuRiyo implements IAnsweringItem {

        /**
         * 選択肢が「介護老人福祉施設」であることを表します。<br />
         * コード : 1
         */
        介護老人福祉施設(1),
        /**
         * 選択肢が「介護老人保健施設」であることを表します。<br />
         * コード : 2
         */
        介護老人保健施設(2),
        /**
         * 選択肢が「介護療養型医療施設」であることを表します。<br />
         * コード : 3
         */
        介護療養型医療施設(3),
        /**
         * 選択肢が「認知症対応型共同生活介護適用施設」であることを表します。<br />
         * コード : 4
         */
        認知症対応型共同生活介護適用施設(4),
        /**
         * 選択肢が「特定施設入居者生活介護適用施設」であることを表します。<br />
         * コード : 5
         */
        特定施設入居者生活介護適用施設(5),
        /**
         * 選択肢が「医療機関_医療保険適用療養病床」であることを表します。<br />
         * コード : 6
         */
        医療機関_医療保険適用療養病床(6),
        /**
         * 選択肢が「医療機関_医療保険適用療養病床」であることを表します。<br />
         * コード : 7
         */
        医療機関_療養病床以外(7),
        /**
         * 選択肢が「その他の施設」であることを表します。<br />
         * コード : 8
         */
        その他の施設(8);
        private int code;

        private ShisetsuRiyo(int code) {
            this.code = code;
        }

        @Override
        public RString getCode() {
            return new RString(Integer.toString(code));
        }

        @Override
        public RString getName() {
            return new RString(name());
        }
    }
}
