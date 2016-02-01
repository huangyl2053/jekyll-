/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.service.report.shikakushutokuidososhitsu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuItem;
import jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuProerty;
import jp.co.ndensan.reams.db.dba.business.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReport;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.HihokenshaKihonEntity;
import jp.co.ndensan.reams.db.dba.entity.report.shikakushutokuidososhitsu.ShikakushutokuIdoSoshitsuReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinSeinengappiHyojihoho;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 介護保険資格取得・異動・喪失届Printクラスです。
 */
public class ShikakuShutokuIdoSoshitsuTodoke {
    
    /**
     * 介護保険資格取得・異動・喪失届Printします。
     * @param 識別コード 識別コード
     * @param 被保険者番号 被保険者番号
     * @return 介護保険資格取得・異動・喪失届作成_帳票
     */
    public SourceDataCollection createKaigoHokenJukyushikakuShomeishoKofuShinseishoChohyo(
            ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        ShikakushutokuIdoSoshitsuProerty proerty = new ShikakushutokuIdoSoshitsuProerty();
        return new Printer<ShikakushutokuIdoSoshitsuReportSource>().spool(proerty, toReports(get被保険者基本情報(識別コード, 被保険者番号)));
    }
    
    private static List<ShikakushutokuIdoSoshitsuReport> toReports(HihokenshaKihonEntity entity) {
        List<ShikakushutokuIdoSoshitsuReport> list = new ArrayList<>();
        // TODO 内部QA: 626 (認証者の取得のメッソードがありません)
        RString 生年月日 = RString.EMPTY;
        if (JuminShubetsu.日本人.getCode().equals(entity.get住民種別コード())
                || JuminShubetsu.住登外個人_日本人.getCode().equals(entity.get住民種別コード())) {
            set生年月日_日本人(entity);
        } else if (JuminShubetsu.外国人.getCode().equals(entity.get住民種別コード())
                || JuminShubetsu.住登外個人_外国人.getCode().equals(entity.get住民種別コード())) {
            生年月日 = set生年月日(entity);
        }
        ShikakushutokuIdoSoshitsuItem item = new ShikakushutokuIdoSoshitsuItem(new RString("認証者"),
                生年月日,
                entity.get住所(),
                // TODO 内部QA: 626 (被保険者基本情報Entity（HihokenshaKihonEntity）に方書がありません)
                RString.EMPTY,
                entity.get被保険者氏名(),
                entity.getフリガナ(),
                entity.get被保険者番号(),
                entity.get性別(),
                entity.get世帯主氏名(),
                entity.get続柄());
        list.add(ShikakushutokuIdoSoshitsuReport.createReport(item));
        return list;
    }
    
    private static RString set生年月日_日本人(HihokenshaKihonEntity entity) {
        if (entity.get生年月日() != null && entity.get生年月日().isEmpty()) {
            return entity.get生年月日()
                    .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }
    
    private static RString set生年月日(HihokenshaKihonEntity entity) {
        RString 外国人表示制御_生年月日表示方法 = BusinessConfig
                .get(ConfigNameDBU.外国人表示制御_生年月日表示方法);
        RString 生年月日 = RString.EMPTY;
        if (GaikokujinSeinengappiHyojihoho.和暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = (entity.get生年月日() == null || entity.get生年月日().isEmpty()) ? RString.EMPTY : entity.get生年月日()
                    .seireki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        } else if (GaikokujinSeinengappiHyojihoho.西暦表示.getコード().equals(外国人表示制御_生年月日表示方法)) {
            生年月日 = set生年月日_和暦表示(entity);
        }
        return 生年月日;
    }
    
    private static RString set生年月日_和暦表示(HihokenshaKihonEntity entity) {
            RString 生年月日 = RString.EMPTY;
            if (!entity.is生年月日不詳区分()) {
                生年月日 = (entity.get生年月日() == null || entity.get生年月日().isEmpty()) ? RString.EMPTY : entity.get生年月日()
                        .wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
        return 生年月日;
    }
    
    
    private HihokenshaKihonEntity get被保険者基本情報(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        HihokenshaKihonEntity entity = new HihokenshaKihonEntity();
        
        return entity;
    }
    
    
}
