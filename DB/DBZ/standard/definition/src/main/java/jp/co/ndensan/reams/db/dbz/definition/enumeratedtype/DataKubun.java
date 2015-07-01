/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * データ区分の列挙型です。
 *
 * @author n8235 船山洋介
 */
public enum DataKubun implements IRStringConvertable {

    /**
     * 通常_認定<br />
     * コード : 00
     */
    通常_認定("00"),
    /**
     * 職権による認定取消<br />
     * コード : 11
     */
    職権による認定取消("11"),
    /**
     * 審査会結果による認定取消<br />
     * コード : 12
     */
    審査会結果による認定取消("12"),
    /**
     * 本人届出_サ利用無による取消<br />
     * コード : 13
     */
    本人届出_サ利用無による取消("13"),
    /**
     * 本人届出_その他による取消<br />
     * コード : 14
     */
    本人届出_その他による取消("14"),
    /**
     * 要介護度3段階低下による取消<br />
     * コード : 15
     */
    要介護度3段階低下による取消("15"),
    /**
     * その他の理由による認定取消<br />
     * コード : 19
     */
    その他の理由による認定取消("19"),
    /**
     * 受給者転入<br />
     * コード : 21
     */
    受給者転入("21"),
    /**
     * 過誤による追加<br />
     * コード : 22
     */
    過誤による追加("22"),
    /**
     * やむを得ない理由による追加<br />
     * コード : 23
     */
    やむを得ない理由による追加("23"),
    /**
     * 職権による追加_修正<br />
     * コード : 24
     */
    職権による追加_修正("24"),
    /**
     * 要介護度3段階低下による追加<br />
     * コード : 25
     */
    要介護度3段階低下による追加("25"),
    /**
     * その他の理由による追加<br />
     * コード : 29
     */
    その他の理由による追加("29"),
    /**
     * 要介護度の変更無しによる却下<br />
     * コード : 31
     */
    要介護度の変更無しによる却下("31"),
    /**
     * 自立による却下<br />
     * コード : 32
     */
    自立による却下("32"),
    /**
     * 訪問調査未実施による却下<br />
     * コード : 33
     */
    訪問調査未実施による却下("33"),
    /**
     * 意見書未実施による却下<br />
     * コード : 34
     */
    意見書未実施による却下("34"),
    /**
     * 審査会都合による却下<br />
     * コード : 35
     */
    審査会都合による却下("35"),
    /**
     * 要介護度3段階低下による却下<br />
     * コード : 36
     */
    要介護度3段階低下による却下("36"),
    /**
     * 職権による却下<br />
     * コード : 00
     */
    職権による却下("37"),
    /**
     * その他の理由による却下<br />
     * コード : 39
     */
    その他の理由による却下("39"),
    /**
     * 過誤による申請取消<br />
     * コード : 41
     */
    過誤による申請取消("41"),
    /**
     * 申請による申請取消<br />
     * コード : 42
     */
    申請による申請取消("42"),
    /**
     * 転出による申請取消<br />
     * コード : 43
     */
    転出による申請取消("43"),
    /**
     * 死亡による申請取消<br />
     * コード : 44
     */
    死亡による申請取消("44"),
    /**
     * 職権による申請取消<br />
     * コード : 45
     */
    職権による申請取消("45"),
    /**
     * その他の理由による申請取消<br />
     * コード : 49
     */
    その他の理由による申請取消("49"),
    /**
     * 開始日同日の区分変更前情報<br />
     * コード : 91
     */
    開始日同日の区分変更前情報("91");

    private final RString code;

    private DataKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.code;
    }

    /**
     * 指定のコードに対応するDataKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するDataKubun
     * @throws IllegalArgumentException 指定のコードに対応するDataKubunがないとき
     */
    public static DataKubun toValue(RString code) throws IllegalArgumentException {
        for (DataKubun target : values()) {
            if (target.code().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する課税区分").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
