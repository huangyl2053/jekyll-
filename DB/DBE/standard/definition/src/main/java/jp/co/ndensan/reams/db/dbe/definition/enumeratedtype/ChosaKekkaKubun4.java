/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査（基本調査第4群）の調査結果を表す列挙型を管理するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ChosaKekkaKubun4 {

    /**
     * 「被害的」の調査結果を表す列挙型です。
     */
    public enum Higaiteki {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private Higaiteki(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static Higaiteki toValue(RString code) {
            for (Higaiteki data : Higaiteki.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「作話」の調査結果を表す列挙型です。
     */
    public enum Sakuwa {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private Sakuwa(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static Sakuwa toValue(RString code) {
            for (Sakuwa data : Sakuwa.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「感情が不安定」の調査結果を表す列挙型です。
     */
    public enum KanjoHuantei {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private KanjoHuantei(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static KanjoHuantei toValue(RString code) {
            for (KanjoHuantei data : KanjoHuantei.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「昼夜逆転」の調査結果を表す列挙型です。
     */
    public enum ChuyaGyakuten {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private ChuyaGyakuten(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static ChuyaGyakuten toValue(RString code) {
            for (ChuyaGyakuten data : ChuyaGyakuten.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「同じ話をする」の調査結果を表す列挙型です。
     */
    public enum OnajiHanashi {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private OnajiHanashi(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static OnajiHanashi toValue(RString code) {
            for (OnajiHanashi data : OnajiHanashi.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「大声を出す」の調査結果を表す列挙型です。
     */
    public enum Ogoe {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private Ogoe(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static Ogoe toValue(RString code) {
            for (Ogoe data : Ogoe.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「介護に抵抗」の調査結果を表す列挙型です。
     */
    public enum KaigoNiTeiko {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private KaigoNiTeiko(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static KaigoNiTeiko toValue(RString code) {
            for (KaigoNiTeiko data : KaigoNiTeiko.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「落ち着きなし」の調査結果を表す列挙型です。
     */
    public enum Ochitsuki {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private Ochitsuki(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static Ochitsuki toValue(RString code) {
            for (Ochitsuki data : Ochitsuki.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「一人で出たがる」の調査結果を表す列挙型です。
     */
    public enum HitoriDeDetagaru {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private HitoriDeDetagaru(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static HitoriDeDetagaru toValue(RString code) {
            for (HitoriDeDetagaru data : HitoriDeDetagaru.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「収集癖」の調査結果を表す列挙型です。
     */
    public enum Shushuheki {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private Shushuheki(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static Shushuheki toValue(RString code) {
            for (Shushuheki data : Shushuheki.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「物や衣類を壊す」の調査結果を表す列挙型です。
     */
    public enum MonoYaIruiWoKowasu {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private MonoYaIruiWoKowasu(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static MonoYaIruiWoKowasu toValue(RString code) {
            for (MonoYaIruiWoKowasu data : MonoYaIruiWoKowasu.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「ひどい物忘れ」の調査結果を表す列挙型です。
     */
    public enum HidoiMonowasure {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private HidoiMonowasure(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static HidoiMonowasure toValue(RString code) {
            for (HidoiMonowasure data : HidoiMonowasure.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「独り言独り笑い」の調査結果を表す列挙型です。
     */
    public enum HitorigotoHitoriwarai {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private HitorigotoHitoriwarai(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static HitorigotoHitoriwarai toValue(RString code) {
            for (HitorigotoHitoriwarai data : HitorigotoHitoriwarai.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「自分勝手に行動する」の調査結果を表す列挙型です。
     */
    public enum JibunKatte {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private JibunKatte(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static JibunKatte toValue(RString code) {
            for (JibunKatte data : JibunKatte.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }

    /**
     * 「話がまとまらない」の調査結果を表す列挙型です。
     */
    public enum HanashiGaMatomaranai {

        /**
         * 調査結果が「ない」であることを表します。
         */
        ない(1),
        /**
         * 調査結果が「ときどきある」であることを表します。
         */
        ときどきある(2),
        /**
         * 調査結果が「ある」であることを表します。
         */
        ある(3);
        private int code;

        private HanashiGaMatomaranai(int code) {
            this.code = code;
        }

        /**
         * コードを返します。
         *
         * @return コード
         */
        public RString getCode() {
            return new RString(Integer.toString(this.code));
        }

        /**
         * コードに対応する列挙型を返します。
         *
         * @param code コード
         * @return 列挙型
         */
        public static HanashiGaMatomaranai toValue(RString code) {
            for (HanashiGaMatomaranai data : HanashiGaMatomaranai.values()) {
                if (data.getCode().equals(code)) {
                    return data;
                }
            }
            return null;
        }
    }
}
