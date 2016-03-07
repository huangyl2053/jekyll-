/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.util.report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 帳票共通クラスです。
 */
public final class ReportUtil {

    private ReportUtil() {
    }

    private static final RString 首長名印字位置 = new RString("1");
    private static final RString 汎用キー_文書番号 = new RString("文書番号");

    /**
     * 雛形部品_認証者を取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     * @param kaisiYMD 開始年月日
     * @param reportSourceWriter ReportSourceWriter
     * @return 認証者情報
     */
    public static NinshoshaSource get認証者情報(SubGyomuCode subGyomuCode,
            ReportId reportId,
            FlexibleDate kaisiYMD,
            ReportSourceWriter reportSourceWriter) {
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu chohyoSeigyoKyotsu = chohyoSeigyoKyotsuManager.get帳票制御共通(subGyomuCode, reportId);
        INinshoshaManager ninshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), kaisiYMD);
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        boolean is公印に掛ける = false;
        boolean is公印を省略 = false;
        if (chohyoSeigyoKyotsu != null) {
            is公印に掛ける = 首長名印字位置.equals(chohyoSeigyoKyotsu.get首長名印字位置());
            is公印を省略 = !chohyoSeigyoKyotsu.is電子公印印字有無();
        }
        return NinshoshaSourceBuilderFactory.createInstance(ninshosha, 導入団体クラス,
                reportSourceWriter.getImageFolderPath(),
                new RDate(kaisiYMD.toString()),
                is公印に掛ける,
                is公印を省略,
                KenmeiFuyoKubunType.付与なし).buildSource();
    }

    /**
     * 文書番号を取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票分類ID
     * @param kaisiYMD 開始年月日
     * @return 文書番号
     */
    public static RString get文書番号(SubGyomuCode subGyomuCode, ReportId reportId, FlexibleDate kaisiYMD) {
        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = bushoFineder.get文書番号管理(reportId, kaisiYMD);
        RString 文書番号 = RString.EMPTY;
        if (bushoNo != null) {
            RString 文書番号発番方法 = bushoNo.get文書番号発番方法();
            if (BunshoNoHatsubanHoho.固定.getCode().equals(文書番号発番方法)) {
                文書番号 = bushoNo.edit文書番号();
            } else if (BunshoNoHatsubanHoho.手入力.getCode().equals(文書番号発番方法)) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("文書番号情報の取得"));
            } else if (BunshoNoHatsubanHoho.自動採番.getCode().equals(文書番号発番方法)) {
                CountedItem 採番 = Saiban.get(subGyomuCode, 汎用キー_文書番号, new FlexibleYear(RDate.getNowDate().getYear().toDateString()));
                文書番号 = bushoNo.edit文書番号(採番.nextString());
            }
        }
        return 文書番号;
    }

    /**
     * 通知文を取得します。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     * @param kamokuCode 科目コード
     * @param patternNo パターン番号
     * @return 通知文
     */
    public static Map<Integer, RString> get通知文(SubGyomuCode subGyomuCode, ReportId reportId, KamokuCode kamokuCode, int patternNo) {
        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo info = tsuchishoTeikeibunManager.get通知書定型文項目(subGyomuCode, reportId, kamokuCode, patternNo);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(subGyomuCode, reportId);
        List<TsuchishoTeikeibunEntity> tsuchishoTeikeibunList = info.get通知書定型文List();
        Map<Integer, RString> 通知文 = new HashMap<>();
        for (TsuchishoTeikeibunEntity tsuchishoTeikeibun : tsuchishoTeikeibunList) {
            int sentenceNo = tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentenceNo();
            通知文.put(sentenceNo, textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence()));
        }
        return 通知文;
    }
}
