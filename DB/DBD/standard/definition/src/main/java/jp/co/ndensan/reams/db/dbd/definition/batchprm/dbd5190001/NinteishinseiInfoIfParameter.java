/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5190001;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD519001_申請情報IF作成_バッチパラメータクラスです。
 *
 * @reamsid_L DBD-1480-020 jinge
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteishinseiInfoIfParameter extends BatchParameterBase {

    private static final String SHOKISAIHOKENSHANO = "shoKisaiHokenshaNo";
    private static final String SHICHOSONCODE = "shichosonCode";
    private static final String HIHOKENSHANO = "hihokenshaNo";
    private static final String KONKAIKAISHIKIKANFROM = "konkaiKaishiKikanFrom";
    private static final String KONKAIKAISHIKIKANTO = "konkaiKaishiKikanTo";
    private static final String NEWFILENAME = "newFileName";
    private static final String HIHOKENSHANOLIST = "hihokenshaNoList";

    @BatchParameter(key = SHICHOSONCODE, name = "市町村コード")
    private LasdecCode shichosonCode;
    @BatchParameter(key = SHOKISAIHOKENSHANO, name = "証記載保険者番号")
    private RString shoKisaiHokenshaNo;
    @BatchParameter(key = HIHOKENSHANO, name = "被保険者番号")
    private RString hihokenshaNo;
    @BatchParameter(key = KONKAIKAISHIKIKANFROM, name = "今回開始期間FROM")
    private RDateTime konkaiKaishiKikanFrom;
    @BatchParameter(key = KONKAIKAISHIKIKANTO, name = "今回開始期間TO")
    private RDateTime konkaiKaishiKikanTo;
    @BatchParameter(key = NEWFILENAME, name = "新ファイル名")
    private RString newFileName;
    @BatchParameter(key = HIHOKENSHANOLIST, name = "対象外被保険者番号リスト")
    private List<RString> hihokenshaNoList;

    /**
     * バッチパラメターを取得します．
     *
     * @return バッチパラメター
     */
    /*TODO
     public NinteishinseiInfoIfProcessParameter toNinteiShinseirenkeiDataSakuseiProcessParameter() {
     return new NinteishinseiInfoIfProcessParameter(shoKisaiHokenshaNo,
     shichosonCode,
     hihokenshaNo,
     konkaiKaishiKikanFrom,
     konkaiKaishiKikanTo,
     newFileName,
     hihokenshaNoList
     );
     }*/
}
