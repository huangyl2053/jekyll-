/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba110010.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * バッチパラメータから、被保険者証発行管理簿の抽出条件パラメータを生成し、それを帳票に設定できる形に編集するためのクラスです。
 *
 * @author n8178
 */
public final class HihokenshashoHakkoKanriExtractionCondition {

    /**
     * 被保険者証発行管理リストに出力できる最大データ数
     */
    private static final RString 証発行モード_被保険者証 = new RString("001");

    private HihokenshashoHakkoKanriExtractionCondition() {
    }

    /**
     * 被保険者証発行管理リストの帳票の、最後のページに印字する抽出条件を作成します。
     *
     * @param parameter バッチパラメータ
     * @param headData 帳票出力データ。共通部分の値設定に使用する
     * @return 抽出条件を帳票に出力可能な状態にまとめたデータ
     */
    public static List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> create(HihokenshashoHakkoKanriboProcessParameter parameter,
            HihohenshashoHakkoKanriboChohyoDataSakuseiEntity headData) {
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> list = new ArrayList<>();

        List<RString> parameterList = createParameterList(parameter);
        RString 隠し改頁項目 = new RString("隠し改頁項目");
        for (int i = 0; i < parameterList.size(); i = i + 2) {
            HihohenshashoHakkoKanriboChohyoDataSakuseiEntity entity = craeteHeadCopyEntity(headData);
            entity.set氏名(parameterList.get(i));
            if (i + 1 < parameterList.size()) {
                entity.set住所(parameterList.get(i + 1));
                entity.set隠し改頁項目(隠し改頁項目);
            }
            list.add(entity);
        }

        return list;
    }

    private static HihohenshashoHakkoKanriboChohyoDataSakuseiEntity craeteHeadCopyEntity(
            HihohenshashoHakkoKanriboChohyoDataSakuseiEntity motoData) {
        HihohenshashoHakkoKanriboChohyoDataSakuseiEntity chohyoDataEntity = new HihohenshashoHakkoKanriboChohyoDataSakuseiEntity();
        chohyoDataEntity.set印刷日時(motoData.get印刷日時());
        chohyoDataEntity.set帳票タイトル(motoData.get帳票タイトル());
        chohyoDataEntity.set市町村コード(motoData.get市町村コード());
        chohyoDataEntity.set市町村名(motoData.get市町村名());

        chohyoDataEntity.setソート順１(motoData.getソート順１());
        chohyoDataEntity.setソート順２(motoData.getソート順２());
        chohyoDataEntity.setソート順３(motoData.getソート順３());
        chohyoDataEntity.setソート順４(motoData.getソート順４());
        chohyoDataEntity.setソート順５(motoData.getソート順５());

        return chohyoDataEntity;
    }

    private static List<RString> createParameterList(HihokenshashoHakkoKanriboProcessParameter param) {
        List<RString> paramList = new ArrayList<>();
        DBACodeShubetsu 交付事由コード種別;
        DBACodeShubetsu 回収事由コード種別;
        if (証発行モード_被保険者証.equals(param.getAkasihakoumod())) {
            交付事由コード種別 = DBACodeShubetsu.被保険者証交付事由;
            回収事由コード種別 = DBACodeShubetsu.被保険者証回収事由;
        } else {
            交付事由コード種別 = DBACodeShubetsu.資格者証交付事由;
            回収事由コード種別 = DBACodeShubetsu.資格者証回収事由;
        }

        List<RString> 抽出条件_期間 = new ArrayList<>();
        抽出条件_期間.add(new RString("＊＊＊　抽出条件　＊＊＊"));
        FlexibleDate 交付日 = param.getKoufukayisihi();
        FlexibleDate 交付終了日 = param.getKoufusiuryouhi();
        set日付範囲条件(抽出条件_期間, new RString("交付年月日"), 交付日, 交付終了日);
        FlexibleDate 回収日 = param.getKasyuukayisihi();
        FlexibleDate 回収終了日 = param.getKasyuusiuryouhi();
        set日付範囲条件(抽出条件_期間, new RString("回収年月日"), 回収日, 回収終了日);
        setSpace(抽出条件_期間);

        List<RString> 抽出条件_交付事由 = new ArrayList<>();
        抽出条件_交付事由.add(new RString("【交付事由】"));
        抽出条件_交付事由.addAll(create事由List(交付事由コード種別, param.getKofuJiyulist()));
        setSpace(抽出条件_交付事由);

        List<RString> 抽出条件_回収事由 = new ArrayList<>();
        抽出条件_回収事由.add(new RString("【回収事由】"));
        抽出条件_回収事由.addAll(create事由List(回収事由コード種別, param.getKaishuJiyulist()));
        setSpace(抽出条件_回収事由);

        paramList.addAll(抽出条件_期間);
        paramList.addAll(抽出条件_交付事由);
        paramList.addAll(抽出条件_回収事由);

        return paramList;
    }

    private static void set日付範囲条件(List<RString> 抽出条件_期間, RString 条件ワード, FlexibleDate 開始日, FlexibleDate 終了日) {
        if (開始日.isEmpty() || 終了日.isEmpty()) {
            return;
        }
        RString str開始日 = 開始日.wareki().toDateString();
        RString str終了日 = 終了日.wareki().toDateString();
        抽出条件_期間.add(条件ワード.concat("：").concat(str開始日).concat("～").concat(str終了日));
    }

    private static List<RString> create事由List(DBACodeShubetsu codeShubetsu, List<RString> jiyuList) {
        List<RString> list = new ArrayList<>();
        FlexibleDate nowDate = FlexibleDate.getNowDate();

        for (RString jiyuCode : jiyuList) {
            RString code = jiyuCode;
            RString meisho = CodeMaster.getCodeMeisho(SubGyomuCode.DBA介護資格, codeShubetsu.getコード(), new Code(jiyuCode), nowDate);
            if (!RString.isNullOrEmpty(meisho)) {
                list.add(code.concat("：").concat(meisho));
            }
        }

        if (list.isEmpty()) {
            list.add(new RString("指定無し"));
        }
        return list;
    }

    private static void setSpace(List<RString> list) {
        if (list.size() % 2 == 0) {
            return;
        }
        list.add(RString.EMPTY);
    }
}
