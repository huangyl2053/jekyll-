/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshashohakkokanribo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KayiSyuuJiyuu;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshashohakkokanribo.KouFuJiyuu;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 被保険者証発行管理簿のクラスです。
 */
public class HihokenshashoHakkoKanriboFinder {

    private static final RString メニューID_DBAMN72001 = new RString("DBAMN72001");
    private static final RString メニューID_DBAMN72002 = new RString("DBAMN72002");
    private static CodeShubetsu codeShubetsu;
    private static RString 証発行モード;
    private static RString 出力対象;
    private static FlexibleDate 交付開始日;
    private static FlexibleDate 交付終了日;
    private static FlexibleDate 回収開始日;
    private static FlexibleDate 回収終了日;
    private static boolean 最新情報フラグ;
    private static boolean 連番付加フラグ;
    private static boolean 項目名付加フラグ;
    private static boolean 日付編集フラグ;
    private static List<UzT0007CodeEntity> 交付事由;
    private static List<UzT0007CodeEntity> 回収事由;
    private static RString 出力順ID;

    /**
     * コンストラクタです。
     */
    HihokenshashoHakkoKanriboFinder() {
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshashoHakkoKanriboFinder}のインスタンスを返します。
     *
     * @return HihokenshashoHakkoKanriboFinder
     */
    public static HihokenshashoHakkoKanriboFinder createInstance() {
        return InstanceProvider.create(HihokenshashoHakkoKanriboFinder.class);
    }

//    /**
//     * バッチ用パラメータ取得です。
//     *
//     * @param parameter バッチ用のパラメータ
//     * @return AkasiHakouKanriParameter バッチ用のパラメータ
//     */
//    @Transaction
//    public AkasiHakouKanriParameter getHihokenshashoHakkoKanriboBatchParameter(AkasiHakouKanriParameter parameter) {
//
//        証発行モード = parameter.getAkasihakoumod();
//        if (parameter.isHakoukannririsutoflg()) {
//            出力対象 = parameter.getSiyuturiyokudaysyou();
//            交付開始日 = parameter.getKoufukayisihi();
//            交付終了日 = parameter.getKoufusiuryouhi();
//            回収開始日 = parameter.getKasyuukayisihi();
//            回収終了日 = parameter.getKasyuusiuryouhi();
//            最新情報フラグ = parameter.isSeyisinjyohoflg();
//        } else {
//            出力対象 = parameter.getSiyuturiyokudaysyou();
//            交付開始日 = parameter.getKoufukayisihi();
//            交付終了日 = parameter.getKoufusiuryouhi();
//            回収開始日 = null;
//            回収終了日 = null;
//            最新情報フラグ = false;
//        }
//        if (parameter.isSubedesentakuflg()) {
//            項目名付加フラグ = true;
//            連番付加フラグ = true;
//            日付編集フラグ = true;
//        } else {
//            項目名付加フラグ = parameter.isKoumukumeyifukaflg();
//            連番付加フラグ = parameter.isRenbanfukaflg();
//            日付編集フラグ = parameter.isHizikehensyuuflg();
//        }
//        交付事由 = parameter.getKayuujiyuulist();
//        回収事由 = parameter.getKasyuujiyuulist();
//        出力順ID = parameter.getSyuturyokujunid();
//        return AkasiHakouKanriParameter.createParam_Batch(
//                証発行モード,
//                出力対象,
//                交付開始日,
//                交付終了日,
//                回収開始日,
//                回収終了日,
//                最新情報フラグ,
//                連番付加フラグ,
//                項目名付加フラグ,
//                日付編集フラグ,
//                交付事由,
//                回収事由,
//                出力順ID);
//    }
    /**
     * チェックを行う。
     *
     * @param 交付開始日 FlexibleDate
     * @param 交付終了日 FlexibleDate
     * @param 回収開始日 FlexibleDate
     * @param 回収終了日 FlexibleDate
     * @return boolean チェック結果
     */
    @Transaction
    public boolean checkInput(FlexibleDate 交付開始日,
            FlexibleDate 交付終了日,
            FlexibleDate 回収開始日,
            FlexibleDate 回収終了日) {
        if (!交付開始日.isEmpty() && !交付終了日.isEmpty()) {
            if ((回収開始日.isEmpty() && 回収終了日.isEmpty()) || (!回収開始日.isEmpty() && !回収終了日.isEmpty())) {
                return false;
            }
        }
        if (交付開始日.isEmpty() && 交付終了日.isEmpty()) {
            if (!回収開始日.isEmpty() && !回収終了日.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 交付事由取得です。
     *
     * @param 処理メニューID RString
     * @return SearchResult<KouFuJiyuu> 交付事由
     */
    @Transaction
    public SearchResult<KouFuJiyuu> getKofuJiyuInitialData(RString 処理メニューID) {
        List<KouFuJiyuu> kouFuJiyuuList = new ArrayList<>();
        if (メニューID_DBAMN72001.equals(処理メニューID)) {
            codeShubetsu = new CodeShubetsu("0002");
        } else if (メニューID_DBAMN72002.equals(処理メニューID)) {
            codeShubetsu = new CodeShubetsu("0004");
        }
        List<UzT0007CodeEntity> codeentityList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, codeShubetsu);
        if (codeentityList == null) {
            return SearchResult.of(Collections.<UzT0007CodeEntity>emptyList(), 0, false);
        }
        for (UzT0007CodeEntity entity : codeentityList) {
            RString name = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, codeShubetsu, entity.getコード());
            entity.setコード名称(name);
            kouFuJiyuuList.add(new KouFuJiyuu(entity));
        }
        return SearchResult.of(kouFuJiyuuList, 0, false);
    }

    /**
     * 回収事由取得です。
     *
     * @param 処理メニューID RString
     * @return SearchResult<KayiSyuuJiyuu> 回収事由
     */
    @Transaction
    public SearchResult<KayiSyuuJiyuu> getKaishuJiyuInitialData(RString 処理メニューID) {
        List<KayiSyuuJiyuu> kayiSyuuJiyuuList = new ArrayList<>();
        if (メニューID_DBAMN72001.equals(処理メニューID)) {
            codeShubetsu = new CodeShubetsu("0003");
        } else if (メニューID_DBAMN72002.equals(処理メニューID)) {
            codeShubetsu = new CodeShubetsu("0005");
        }
        List<UzT0007CodeEntity> codeentityList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, codeShubetsu);
        if (codeentityList == null) {
            return SearchResult.of(Collections.<UzT0007CodeEntity>emptyList(), 0, false);
        }
        for (UzT0007CodeEntity entity : codeentityList) {
            RString name = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, codeShubetsu, entity.getコード());
            entity.setコード名称(name);
            kayiSyuuJiyuuList.add(new KayiSyuuJiyuu(entity));
        }
        return SearchResult.of(kayiSyuuJiyuuList, 0, false);
    }
}
