/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5020011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigoninteiinterface.YokaigoNinteiInterface;
import jp.co.ndensan.reams.db.dbd.business.core.yokaigoninteitaisyosyaichiran.YokaigoNinteiTaisyosyaIchiran;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020011.dgNinteiTaishosha_Row;
import jp.co.ndensan.reams.db.dbd.service.report.yokaigoninteitaisyosyaichiran.YokaigoNinteiTaisyosyaIchiranManager;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import static jp.co.ndensan.reams.uz.uza.lang.RDate.getNowDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定処理対象者一覧画面のHandlerです。
 *
 * @reamsid_L DBD-1531-010 chenxin
 */
public class YokaigoNinteiTaishoshaListHandler {

    /**
     * 受給者台帳及び要介護認定インターフェース情報または認定結果情報から、画面表示する項目を検索する。
     *
     * @return 要介護認定処理対象者一覧
     */
    public List<dgNinteiTaishosha_Row> onLoad() {
        ShichosonSecurityJoho 市町村セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定);
        RString 導入形態コード = null;
        if (市町村セキュリティ情報.get導入形態コード() != null) {
            導入形態コード = 市町村セキュリティ情報.get導入形態コード().getColumnValue();
        }

        List<dgNinteiTaishosha_Row> 画面情報一覧 = new ArrayList<>();
        if (DonyuKeitaiCode.認定広域.getCode().equals(導入形態コード)) {
            get広域タイプ情報(画面情報一覧);
        } else {
            get単独タイプ情報(画面情報一覧);
        }
        return 画面情報一覧;
    }

    /**
     * 要介護認定インターフェース更新用情報を取得 ＠
     *
     * @param ninteiTaishoshalist List<dgNinteiTaishosha_Row>
     * @return 要介護認定インターフェース更新用情報
     */
    public ArrayList<YokaigoNinteiInterface> get要介護認定インターフェース情報(List<dgNinteiTaishosha_Row> ninteiTaishoshalist) {
        if (ninteiTaishoshalist.isEmpty()) {
            return new ArrayList<>();
        }
        YokaigoNinteiTaisyosyaIchiranManager manager = YokaigoNinteiTaisyosyaIchiranManager.createInstance();
        List<RString> 申請書管理番号リスト = new ArrayList<>();
        for (dgNinteiTaishosha_Row ninteiTaishoshaRow : ninteiTaishoshalist) {
            申請書管理番号リスト.add(ninteiTaishoshaRow.get更新key());
        }
        return manager.get要介護認定インターフェース情報リスト(申請書管理番号リスト);
    }

    private List<dgNinteiTaishosha_Row> get広域タイプ情報(List<dgNinteiTaishosha_Row> 画面情報一覧) {
        YokaigoNinteiTaisyosyaIchiranManager manager = YokaigoNinteiTaisyosyaIchiranManager.createInstance();
        List<YokaigoNinteiTaisyosyaIchiran> yokgNtTaisyosyaIchiranList = manager.get広域タイプリスト();

        for (YokaigoNinteiTaisyosyaIchiran yokaigoNinteiTaisyosyaIchiran : yokgNtTaisyosyaIchiranList) {
            dgNinteiTaishosha_Row 画面情報 = new dgNinteiTaishosha_Row();
            画面情報.set被保険者番号(yokaigoNinteiTaisyosyaIchiran.get被保険者番号());
            画面情報.set氏名(yokaigoNinteiTaisyosyaIchiran.get申請情報被保険者氏名());
            画面情報.set判定(yokaigoNinteiTaisyosyaIchiran.get取下区分コード());
            画面情報.set申請申(yokaigoNinteiTaisyosyaIchiran.get申請種別コード());
            画面情報.set申請法(yokaigoNinteiTaisyosyaIchiran.get予備区分4());
            画面情報.set申請日(yokaigoNinteiTaisyosyaIchiran.get認定申請日());
            画面情報.set取込日時(yokaigoNinteiTaisyosyaIchiran.get取込日時());
            画面情報.set一次判定日(yokaigoNinteiTaisyosyaIchiran.get一次判定日());
            画面情報.set一次判定(yokaigoNinteiTaisyosyaIchiran.get一次判定結果());
            画面情報.set二次判定日(yokaigoNinteiTaisyosyaIchiran.get二次判定日());
            画面情報.set二次判定(yokaigoNinteiTaisyosyaIchiran.get二次判定結果());
            画面情報.set適用開始日(yokaigoNinteiTaisyosyaIchiran.get認定有効開始年月日());
            画面情報.set適用終了日(yokaigoNinteiTaisyosyaIchiran.get認定有効終了年月日());
            画面情報.set更新key(yokaigoNinteiTaisyosyaIchiran.get申請書管理番号());
            画面情報一覧.add(画面情報);
        }
        return 画面情報一覧;
    }

    private List<dgNinteiTaishosha_Row> get単独タイプ情報(List<dgNinteiTaishosha_Row> 画面情報一覧) {
        YokaigoNinteiTaisyosyaIchiranManager manager = YokaigoNinteiTaisyosyaIchiranManager.createInstance();
        List<YokaigoNinteiTaisyosyaIchiran> yokgNtTaisyosyaIchiranList = manager.get単独タイプリスト();
        for (YokaigoNinteiTaisyosyaIchiran yokaigoNinteiTaisyosyaIchiran : yokgNtTaisyosyaIchiranList) {
            dgNinteiTaishosha_Row 画面情報 = new dgNinteiTaishosha_Row();
            画面情報.set被保険者番号(yokaigoNinteiTaisyosyaIchiran.get受給者申請書管理番号());
            画面情報.set氏名(yokaigoNinteiTaisyosyaIchiran.get申請情報被保険者氏名());
            画面情報.set判定(yokaigoNinteiTaisyosyaIchiran.get申請情報取下区分コード());
            画面情報.set申請申(yokaigoNinteiTaisyosyaIchiran.get申請情報認定申請区分申請時コード());
            画面情報.set申請法(yokaigoNinteiTaisyosyaIchiran.get申請情報認定申請区分法令コード());
            画面情報.set申請日(yokaigoNinteiTaisyosyaIchiran.get申請情報認定申請年月日());
            画面情報.set取込日時(yokaigoNinteiTaisyosyaIchiran.get取込日時2());
            画面情報.set一次判定日(yokaigoNinteiTaisyosyaIchiran.get要介護認定一次判定年月日());
            画面情報.set一次判定(yokaigoNinteiTaisyosyaIchiran.get要介護認定一次判定結果コード認知症加算());
            画面情報.set二次判定日(yokaigoNinteiTaisyosyaIchiran.get結果情報二次判定年月日());
            画面情報.set二次判定(yokaigoNinteiTaisyosyaIchiran.get結果情報二次判定要介護状態区分コード());
            画面情報.set適用開始日(yokaigoNinteiTaisyosyaIchiran.get結果情報二次判定認定有効開始年月日());
            画面情報.set適用終了日(yokaigoNinteiTaisyosyaIchiran.get結果情報二次判定認定有効開始年月日());
            画面情報.set更新key(yokaigoNinteiTaisyosyaIchiran.get受給者申請書管理番号());
            画面情報一覧.add(画面情報);
        }
        return 画面情報一覧;
    }

    /**
     * save消込処理
     *
     * @param 申請書管理番号 RString
     * @param yokaigoNinteiInterfaceList ArrayList<YokaigoNinteiInterface>
     */
    public void save消込(RString 申請書管理番号, ArrayList<YokaigoNinteiInterface> yokaigoNinteiInterfaceList) {
        for (YokaigoNinteiInterface yokaigoNinteiInterface : yokaigoNinteiInterfaceList) {
            if (yokaigoNinteiInterface.get申請書管理番号().value().equals(申請書管理番号)) {
                yokaigoNinteiInterface = yokaigoNinteiInterface.createBuilderForEdit()
                        .set消し込みフラグ(new RString("1"))
                        .set消し込み日時(new YMDHMS(getNowDateTime()))
                        .build()
                        .modifiedModel();
                YokaigoNinteiTaisyosyaIchiranManager.createInstance().save(yokaigoNinteiInterface);
            }
        }
    }

}
