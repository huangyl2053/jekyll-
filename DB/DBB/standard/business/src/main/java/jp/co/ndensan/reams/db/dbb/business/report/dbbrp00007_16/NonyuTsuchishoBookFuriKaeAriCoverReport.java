/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.NonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書
 */
public class NonyuTsuchishoBookFuriKaeAriCoverReport extends Report<NonyuTsuchishoBookFuriKaeAriCoverSource> {

    private final NonyuTsuchishoBookItem item;

    /**
     * コンストラクタです。
     *
     * @param item NonyuTsuchishoBookItem
     */
    protected NonyuTsuchishoBookFuriKaeAriCoverReport(NonyuTsuchishoBookItem item) {
        this.item = item;
    }

    /**
     *
     * @param item NonyuTsuchishoBookItem
     * @return NonyuTsuchishoBookFuriKaeAriCoverReport
     * @throws NullPointerException 引数が{@code null}の時
     */
    public NonyuTsuchishoBookFuriKaeAriCoverReport createFrom(NonyuTsuchishoBookItem item) {
        return new NonyuTsuchishoBookFuriKaeAriCoverReport(item);
    }

    @Override
    public void writeBy(ReportSourceWriter<NonyuTsuchishoBookFuriKaeAriCoverSource> writer) {
        HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報 = item.get本算定納入通知書情報();
        if (null == 本算定納入通知書情報) {
            本算定納入通知書情報 = new HonSanteiNonyuTsuchiShoJoho();
        }
        List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト = 本算定納入通知書情報.get納入通知書期情報リスト();
        if (納入通知書期情報リスト.isEmpty()) {
            納入通知書期情報リスト = new ArrayList<>();
        }

        // TODO 雛形部品CompNinshoshaを作成する
        // TODO 帳票制御情報を取得する 
        // 帳票制御共通（DbT7065ChohyoSeigyoKyotsu）
        // パラメータ：　サブ業務コード　＝　DBB
        //	　　　   帳票分類ID　＝　"DBB100045_HokenryoNonyuTsuchishoDaihyo"
        Ninshosha 帳票認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), new FlexibleDate(本算定納入通知書情報.get発行日().toDateString()));
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        // TODO is公印に掛ける　=　帳票制御共通.首長名印字位置 が 1（公印にかける）のとき　True
        // TODO is公印を省略　=　帳票制御共通.電子公印印字有無　が　False　のとき、True
        INinshoshaSourceBuilder iNinshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(帳票認証者,
                地方公共団体, writer.getImageFolderPath(), 本算定納入通知書情報.get発行日(), true, true, KenmeiFuyoKubunType.付与なし);
        NinshoshaSource ninshoshaSource = iNinshoshaSourceBuilder.buildSource();

        // TODO 共通部品CompSofubutsuAtesakiを作成する
        SofubutsuAtesakiSource sofubutsuAtesakiSource = 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource();
        int 連番 = 1;

        for (NonyuTsuchiShoKiJoho 納入通知書期情報 : 納入通知書期情報リスト) {
            if (納入通知書期情報.get納付額().compareTo(Decimal.ZERO) <= 0) {
                continue;
            }
            INonyuTsuchishoBookFuriKaeAriCoverEditor editor = new NonyuTsuchishoBookFuriKaeAriCoverEditor(item,
                    連番, ninshoshaSource, sofubutsuAtesakiSource);
            INonyuTsuchishoBookFuriKaeAriCoverBuilder builder = new NonyuTsuchishoBookFuriKaeAriCoverBuilder(editor);
            writer.writeLine(builder);
            連番++;
        }
    }

}
