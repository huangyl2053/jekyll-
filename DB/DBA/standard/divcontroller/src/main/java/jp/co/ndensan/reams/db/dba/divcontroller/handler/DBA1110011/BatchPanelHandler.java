/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.DBA1110011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KayiSyuuJiyuu;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KouFuJiyuu;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.BatchPanelDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.dgKaishuJiyu_Row;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1110011.dgKoufuJiyu_Row;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv.DisplayNone;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 *
 * 被保険者証発行管理簿ハンドラクラスです。
 */
public class BatchPanelHandler {

    private final BatchPanelDiv div;
    private static final RString 未回収者リスト_key = new RString("key1");
    private static final RString 項目名付加 = new RString("項目名付加");
    private static final RString 連番付加 = new RString("連番付加");
    private static final RString 日付編集 = new RString("日付'/'編集");
    private static final RString 被保険者証発行管理 = new RString("DBAMN72001");
    private static final RString 資格者証発行管理 = new RString("DBAMN72002");
    private static final RString 証発行モード_001 = new RString("001");
    private static final RString 証発行モード_002 = new RString("002");
    private static final RString 発行管理リスト = new RString("1");
    private static final RString 未回収者リスト = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div 被保険者証発行管理簿Div
     */
    public BatchPanelHandler(BatchPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理します。
     *
     * @param kouFuJiyuuList 交付事由リスト
     * @param kayiSyuuJiyuuList　回収事由リスト
     */
    public void initialize(List<KouFuJiyuu> kouFuJiyuuList, List<KayiSyuuJiyuu> kayiSyuuJiyuuList) {
        List<dgKaishuJiyu_Row> dgKaishuJiyuRowList = new ArrayList<>();
        List<dgKoufuJiyu_Row> dgKoufuJiyuRowList = new ArrayList<>();
        for (KouFuJiyuu KouFuJiyuu : kouFuJiyuuList) {
            dgKoufuJiyu_Row dgKoufuJiyuRow = new dgKoufuJiyu_Row();
            dgKoufuJiyuRow.setTxtKofuJiyuCode(new RString(KouFuJiyuu.getコード().toString()));
            dgKoufuJiyuRow.setTxtKofuJiyu(KouFuJiyuu.getコード名称());
            dgKoufuJiyuRowList.add(dgKoufuJiyuRow);

        }
        for (KayiSyuuJiyuu kayiSyuuJiyuu : kayiSyuuJiyuuList) {
            dgKaishuJiyu_Row dgKaishuJiyuRow = new dgKaishuJiyu_Row();
            dgKaishuJiyuRow.setTxtKaishuJiyuCode(new RString(kayiSyuuJiyuu.getコード().toString()));
            dgKaishuJiyuRow.setTxtKaishuJiyu(kayiSyuuJiyuu.getコード名称());
            dgKaishuJiyuRowList.add(dgKaishuJiyuRow);
        }
        div.getDgKaishuJiyu().setDataSource(dgKaishuJiyuRowList);
        div.getDgKoufuJiyu().setDataSource(dgKoufuJiyuRowList);
        div.getCcdChohyoShutsuryokujun().setVisible(true);
        SubGyomuCode subGyomuCode = div.getCcdChohyoShutsuryokujun().getサブ業務コード();
        ReportId reportId = div.getCcdChohyoShutsuryokujun().get帳票ID();

        DisplayNone displayNone = DisplayNone.SORT_ONLY;

    }

    /**
     * バッチパラメータを作成します
     *
     * @param kouFuJiyuuList 交付事由リスト
     * @param kayiSyuuJiyuuList　回収事由リスト
     * @param menuID 処理メニューID
     * @return HihokenshashoHakkoKanriboBatchParameter 被保険者証発行管理簿_バッチ用のパラメータ
     */
    public HihokenshashoHakkoKanriboBatchParameter batchParameter(List<KouFuJiyuu> kouFuJiyuuList,
            List<KayiSyuuJiyuu> kayiSyuuJiyuuList, RString menuID) {
        HihokenshashoHakkoKanriboBatchParameter parameter = new HihokenshashoHakkoKanriboBatchParameter();
        if (被保険者証発行管理.equals(menuID)) {
            parameter.setAkasihakoumod(証発行モード_001);
        } else if (資格者証発行管理.equals(menuID)) {
            parameter.setAkasihakoumod(証発行モード_002);
        }
        if (未回収者リスト_key.equals(div.getRadShutsuTaisho().getSelectedKey())) {
            parameter.setSiyuturiyokudaysyou(未回収者リスト);
            parameter.setKoufukayisihi(new FlexibleDate(div.getTxtKoufubiRange().getFromValue().toDateString()));
            parameter.setKoufusiuryouhi(new FlexibleDate(div.getTxtKoufubiRange().getToValue().toDateString()));
            parameter.setKasyuukayisihi(FlexibleDate.EMPTY);
            parameter.setKasyuusiuryouhi(FlexibleDate.EMPTY);
            parameter.setSeyisinjyohoflg(false);
        } else {
            parameter.setSiyuturiyokudaysyou(発行管理リスト);
            parameter.setKoufukayisihi(new FlexibleDate(div.getTxtKoufubiRange().getFromValue().toDateString()));
            parameter.setKoufusiuryouhi(new FlexibleDate(div.getTxtKoufubiRange().getToValue().toDateString()));
            parameter.setKasyuukayisihi(new FlexibleDate(div.getTxtKaishubiRange().getFromValue().toDateString()));
            parameter.setKasyuusiuryouhi(new FlexibleDate(div.getTxtKaishubiRange().getToValue().toDateString()));
            if (div.getChkSaishinJoho().getSelectedItems().size() > 0) {
                parameter.setSeyisinjyohoflg(true);
            } else {
                parameter.setSeyisinjyohoflg(false);
            }
        }
        if (div.getChkHenshuHoho().getSelectedItems().size() > 0) {
            parameter.setKoumukumeyifukaflg(true);
            parameter.setRenbanfukaflg(true);
            parameter.setHizikehensyuuflg(true);
        } else {
            if (項目名付加.equals(div.getChkHenshuHoho().getSelectedItems().get(0).getValue())) {
                parameter.setKoumukumeyifukaflg(true);
            } else {
                parameter.setKoumukumeyifukaflg(false);
            }
            if (連番付加.equals(div.getChkHenshuHoho().getSelectedItems().get(1).getValue())) {
                parameter.setRenbanfukaflg(true);
            } else {
                parameter.setRenbanfukaflg(false);
            }
            if (日付編集.equals(div.getChkHenshuHoho().getSelectedItems().get(2).getValue())) {
                parameter.setHizikehensyuuflg(true);
            } else {
                parameter.setHizikehensyuuflg(false);
            }
        }
        UzT0007CodeEntity entity1 = new UzT0007CodeEntity();
        List<RString> entityList1 = new ArrayList<>();
        for (KouFuJiyuu KouFuJiyuu : kouFuJiyuuList) {
            entity1.setコード(KouFuJiyuu.getコード());
            entityList1.add(entity1.getコード().value());
        }
        parameter.setKayuujiyuulist(entityList1);
        UzT0007CodeEntity entity2 = new UzT0007CodeEntity();
        List<RString> entityList2 = new ArrayList<>();
        for (KayiSyuuJiyuu kayiSyuuJiyuu : kayiSyuuJiyuuList) {
            entity2.setコード(kayiSyuuJiyuu.getコード());
            entityList2.add(entity2.getコード().value());
        }
        parameter.setKasyuujiyuulist(entityList2);
        parameter.setSyuturyokujunid(div.getCcdChohyoShutsuryokujun().getFocusPositionID());

        return parameter;

    }
}
