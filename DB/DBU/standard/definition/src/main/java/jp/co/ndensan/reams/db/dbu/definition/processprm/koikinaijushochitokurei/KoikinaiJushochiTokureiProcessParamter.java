/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.definition.processprm.koikinaijushochitokurei;

import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.koikinaijushochitokurei.KoikinaiJushochiTokureiMybatisparamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 広域内住所地特例者一覧表のバッチ処理クラスのパラメータ
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KoikinaiJushochiTokureiProcessParamter implements IBatchProcessParameter {
    
    private final RString model;
    private final RString shichosonCode;
    private final RString shichosonName;
    private final RString idoYMD;
    private final RString kaishibi;
    private final RString shuryobi;
    private final RString narabiId;
    
    /**
     * コンストラクタです。
     * @param model 取得モード
     * @param shichosonCode 市町村コード
     * @param shichosonName 市町村名称
     * @param idoYMD 基準日
     * @param kaishibi 今回開始日
     * @param shuryobi 今回終了日
     * @param narabiId 出力順ID
     */
    public KoikinaiJushochiTokureiProcessParamter(RString model,
            RString shichosonCode,
            RString shichosonName,
            RString idoYMD,
            RString kaishibi,
            RString shuryobi,
            RString narabiId) {
        this.model = model;
        this.shichosonCode = shichosonCode;
        this.shichosonName = shichosonName;
        this.idoYMD = idoYMD;
        this.kaishibi = kaishibi;
        this.shuryobi = shuryobi;
        this.narabiId = narabiId;
    }
    
    /**
     * 域内住所地特例者一覧表のMyBatisパラメータ作成です。
     *
     * @param psmShikibetsuTaisho 宛名識別対象パラメータ
     * @return 域内住所地特例者一覧表のMyBatisパラメータ
     */
    public KoikinaiJushochiTokureiMybatisparamter toMybatisParamter(RString psmShikibetsuTaisho) {
        return KoikinaiJushochiTokureiMybatisparamter.createParamter(shichosonCode, idoYMD, kaishibi, shuryobi, psmShikibetsuTaisho);
    }
}
