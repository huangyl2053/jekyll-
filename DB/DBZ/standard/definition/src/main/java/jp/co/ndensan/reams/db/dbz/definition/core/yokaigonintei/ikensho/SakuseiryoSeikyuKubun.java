/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 作成料請求区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum SakuseiryoSeikyuKubun {

    /**
     * コード:11 名称:在宅新規 略称:定義なし
     */
    在宅新規("11", "在宅新規", ZaitakuShisetsuKubun.在宅, IkenshoSakuseiKaisuKubun.初回),
    /**
     * コード:12 名称:在宅継続 略称:定義なし
     */
    在宅継続("12", "在宅継続", ZaitakuShisetsuKubun.在宅, IkenshoSakuseiKaisuKubun._2回目以降),
    /**
     * コード:21 名称:施設新規 略称:定義なし
     */
    施設新規("21", "施設新規", ZaitakuShisetsuKubun.施設, IkenshoSakuseiKaisuKubun.初回),
    /**
     * コード:22 名称:施設継続 略称:定義なし
     */
    施設継続("22", "施設継続", ZaitakuShisetsuKubun.施設, IkenshoSakuseiKaisuKubun._2回目以降);

    private final RString code;

    private final RString fullName;
    private final ZaitakuShisetsuKubun zaitakuShisetsuKubun;
    private final IkenshoSakuseiKaisuKubun ikenshoSakuseiKaisuKubun;

    private SakuseiryoSeikyuKubun(String code, String fullname, ZaitakuShisetsuKubun 在宅施設区分, IkenshoSakuseiKaisuKubun 意見書作成回数区分) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.zaitakuShisetsuKubun = 在宅施設区分;
        this.ikenshoSakuseiKaisuKubun = 意見書作成回数区分;
    }

    /**
     * 作成料請求区分のコードを返します。
     *
     * @return 作成料請求区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 作成料請求区分の名称を返します。
     *
     * @return 作成料請求区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * @return 対応する在宅施設区分
     */
    public ZaitakuShisetsuKubun as在宅施設区分() {
        return this.zaitakuShisetsuKubun;
    }

    /**
     * @return 対応する作成回数区分
     */
    public IkenshoSakuseiKaisuKubun as作成回数区分() {
        return this.ikenshoSakuseiKaisuKubun;
    }

    /**
     * 作成料請求区分のコードと一致する内容を探します。
     *
     * @param code 作成料請求区分のコード
     * @return {@code code} に対応する作成料請求区分
     */
    public static SakuseiryoSeikyuKubun toValue(RString code) {

        for (SakuseiryoSeikyuKubun sakuseiryoSeikyuKubun : SakuseiryoSeikyuKubun.values()) {
            if (sakuseiryoSeikyuKubun.code.equals(code)) {
                return sakuseiryoSeikyuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("作成料請求区分"));
    }

    /**
     * 指定のコードと対応する値が存在する場合、{@code true}を返します。
     *
     * @param code 存在の有無を検索する対象のコード
     * @return 指定のコードと対応する値が存在する場合、{@code true}.
     */
    public static boolean existsCode(RString code) {
        for (SakuseiryoSeikyuKubun v : values()) {
            if (v.code.equals(code)) {
                return true;
            }
        }
        return false;
    }
}
