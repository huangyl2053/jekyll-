/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taishouwaritsuke;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護認定審査会対象者候補者一覧エリア内容検索パラメータクラス。
 *
 * @reamsid_L DBE-0140-010 liangbc
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KohoshaIchiranMapperParameter {

    private final RString kaisaiNo;
    private final boolean isItijiHannteiAto;
    private final RString tsujou;
    private final RString ennki;
    private final boolean isDummyGogitai;

    /**
     * コンストラクタです。
     *
     * @param kaisaiNo 開催番号
     * @param isItijiHannteiAto マスキングが一次判定後フラグ
     * @param isDummyGogitai 研修合議体フラグ
     */
    private KohoshaIchiranMapperParameter(RString kaisaiNo, boolean isItijiHannteiAto, boolean isDummyGogitai) {
        this.kaisaiNo = kaisaiNo;
        this.isItijiHannteiAto = isItijiHannteiAto;
        this.tsujou = ShoriJotaiKubun.通常.getコード();
        this.ennki = ShoriJotaiKubun.延期.getコード();
        this.isDummyGogitai = isDummyGogitai;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param kaisaiNo 開催番号
     * @param isItijiHannteiAto マスキングが一次判定後フラグ
     * @param isDummyGogitai 研修合議体フラグ
     * @return 介護認定審査会対象者候補者一覧エリア内容検索パラメータ
     */
    public static KohoshaIchiranMapperParameter createKohoshaIchiranMapperParameter(RString kaisaiNo, boolean isItijiHannteiAto, boolean isDummyGogitai) {
        return new KohoshaIchiranMapperParameter(kaisaiNo, isItijiHannteiAto, isDummyGogitai);
    }
}
