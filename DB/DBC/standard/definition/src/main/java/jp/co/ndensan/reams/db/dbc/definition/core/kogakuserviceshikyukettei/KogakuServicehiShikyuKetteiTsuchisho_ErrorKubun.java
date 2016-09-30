/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kogakuserviceshikyukettei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額サービス費支給決定通知書_エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-2000-030 wangxue
 */
public enum KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun {

    /**
     * コード:H1 名称:基本情報レコード 略称:定義なし
     */
    宛名取得("01", "宛名取得");

    private final RString code;
    private final RString fullName;

    private KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付実績レコード種別のコードを返します。
     *
     * @return 給付実績レコード種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付実績レコード種別の名称を返します。
     *
     * @return 給付実績レコード種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処理名を取ります
     *
     * @param code コード
     * @return 処理名
     */
    public static RString get処理名(RString code) {
        if (KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun.宛名取得.getコード().equals(code)) {
            return new RString("通知対象データ取得");
        }
        return null;
    }

    /**
     * エラーメッセージを取ります
     *
     * @param code コード
     * @return エラーメッセージ
     */
    public static RString getエラーメッセージ(RString code) {
        if (KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun.宛名取得.getコード().equals(code)) {
            return new RString("宛名データがありません。");
        }
        return null;
    }

    /**
     * 国保連情報作成エラー区分のコードと一致する内容を探します。
     *
     * @param code 国保連情報作成エラー区分のコード
     * @return {@code code} に対応する国保連情報作成エラー区分
     */
    public static KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun toValue(RString code) {
        for (KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun errorKubun : KogakuServicehiShikyuKetteiTsuchisho_ErrorKubun.values()) {
            if (errorKubun.code.equals(code)) {
                return errorKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額サービス費支給決定通知書_エラー区分"));
    }

}
