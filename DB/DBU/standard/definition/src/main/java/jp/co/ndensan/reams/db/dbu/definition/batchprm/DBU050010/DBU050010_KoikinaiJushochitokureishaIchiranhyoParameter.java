/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.batchprm.DBU050010;

import jp.co.ndensan.reams.db.dbu.definition.processprm.koikinaijushochitokurei.KoikinaiJushochiTokureiProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 広域内住所地特例者一覧表_バッチパラメータクラスです。
 *
 * @reamsid_L DBU-1140-020 dongyabin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBU050010_KoikinaiJushochitokureishaIchiranhyoParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_MODEL = "model";
    private static final String SHICHOSON_CODE = "shichosonCode";
    private static final String SHICHOSON_NAME = "shichosonName";
    private static final String KIJYUNBI = "kijyunbi";
    private static final String KAISHIBI = "kaishibi";
    private static final String SHURYOBI = "shuryobi";
    private static final String NARABI_ID = "narabiId";

    @BatchParameter(key = KEY_MODEL, name = "取得モード")
    private RString model;
    @BatchParameter(key = SHICHOSON_CODE, name = "市町村コード")
    private RString shichosonCode;
    @BatchParameter(key = SHICHOSON_NAME, name = "市町村名称")
    private RString shichosonName;
    @BatchParameter(key = KIJYUNBI, name = "基準日")
    private RString kijyunbi;
    @BatchParameter(key = KAISHIBI, name = "今回開始日")
    private RString kaishibi;
    @BatchParameter(key = SHURYOBI, name = "今回終了日")
    private RString shuryobi;
    @BatchParameter(key = NARABI_ID, name = "出力順ID")
    private RString narabiId;

    /**
     * 域内住所地特例者一覧表のProcessParamterパラメータ作成です。
     *
     * @return 域内住所地特例者一覧表のProcessParamterパラメータ
     */
    public KoikinaiJushochiTokureiProcessParamter toProcessParamter() {
        return new KoikinaiJushochiTokureiProcessParamter(model,
                shichosonCode,
                shichosonName,
                kijyunbi,
                kaishibi,
                shuryobi,
                narabiId);
    }

}
