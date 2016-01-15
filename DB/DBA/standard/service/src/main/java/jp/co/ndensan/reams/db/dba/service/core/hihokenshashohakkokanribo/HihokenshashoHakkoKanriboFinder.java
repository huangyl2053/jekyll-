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
    private static final CodeShubetsu コード種別_002 = new CodeShubetsu("002");
    private static final CodeShubetsu コード種別_003 = new CodeShubetsu("003");
    private static final CodeShubetsu コード種別_004 = new CodeShubetsu("004");
    private static final CodeShubetsu コード種別_005 = new CodeShubetsu("005");

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

    /**
     * チェックを行う。
     *
     * @param koufubiFrom 交付開始日
     * @param koufubiTo 交付終了日
     * @param kaishubiFrom 回収開始日
     * @param kaishubiTo 回収終了日
     * @return boolean チェック結果
     */
    @Transaction
    public boolean checkInput(FlexibleDate koufubiFrom,
            FlexibleDate koufubiTo,
            FlexibleDate kaishubiFrom,
            FlexibleDate kaishubiTo) {
        if (!koufubiFrom.isEmpty() && !koufubiTo.isEmpty()) {
            if ((kaishubiFrom.isEmpty() && kaishubiTo.isEmpty())
                    || (!kaishubiFrom.isEmpty() && !kaishubiTo.isEmpty())) {
                return false;
            }
        } else if (koufubiFrom.isEmpty() && koufubiTo.isEmpty()
                && !kaishubiFrom.isEmpty() && !kaishubiTo.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * 交付事由取得です。
     *
     * @param menuID 処理メニューID
     * @return SearchResult<KouFuJiyuu> 交付事由りすと
     */
    @Transaction
    public SearchResult<KouFuJiyuu> getKofuJiyuInitialData(RString menuID) {
        List<KouFuJiyuu> kouFuJiyuuList = new ArrayList<>();
        CodeShubetsu codeShubetsu = CodeShubetsu.EMPTY;
        if (メニューID_DBAMN72001.equals(menuID)) {
            codeShubetsu = コード種別_002;
        } else if (メニューID_DBAMN72002.equals(menuID)) {
            codeShubetsu = コード種別_004;
        }
        List<UzT0007CodeEntity> entityList = CodeMaster.getCode(SubGyomuCode.DBA介護資格, codeShubetsu);
        if (entityList == null) {
            return SearchResult.of(Collections.<UzT0007CodeEntity>emptyList(), 0, false);
        }
        for (UzT0007CodeEntity entity : entityList) {
            RString name = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, codeShubetsu, entity.getコード());
            entity.setコード名称(name);
            kouFuJiyuuList.add(new KouFuJiyuu(entity));
        }
        return SearchResult.of(kouFuJiyuuList, 0, false);
    }

    /**
     * 回収事由取得です。
     *
     * @param menuID 処理メニューID
     * @return SearchResult<KayiSyuuJiyuu> 回収事由りすと
     */
    @Transaction
    public SearchResult<KayiSyuuJiyuu> getKaishuJiyuInitialData(RString menuID) {
        List<KayiSyuuJiyuu> kayiSyuuJiyuuList = new ArrayList<>();
        CodeShubetsu codeShubetsu = CodeShubetsu.EMPTY;
        if (メニューID_DBAMN72001.equals(menuID)) {
            codeShubetsu = コード種別_003;
        } else if (メニューID_DBAMN72002.equals(menuID)) {
            codeShubetsu = コード種別_005;
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
