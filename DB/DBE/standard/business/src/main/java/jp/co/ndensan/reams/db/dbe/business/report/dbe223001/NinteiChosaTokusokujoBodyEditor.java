/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;

/**
 *
 * 要介護認定調査督促状のEditorです。
 */
public class NinteiChosaTokusokujoBodyEditor implements INinteiChosaTokusokujoEditor {

    private final NinteiChosaTokusokujoBodyItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link NinteiChosaTokusokujoBodyEditor}
     */
    protected NinteiChosaTokusokujoBodyEditor(NinteiChosaTokusokujoBodyItem item) {
        this.item = item;
    }

    @Override
    public NinteiChosaTokusokujoReportSource edit(NinteiChosaTokusokujoReportSource source) {
        return editBody(source);
    }

    private NinteiChosaTokusokujoReportSource editBody(NinteiChosaTokusokujoReportSource source) {

        INinshoshaSourceBuilder iNinshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance (item.get認証者情報(), item.get公共団体情報(),
                item.getイメージファイルパス(), item.get発行日(), item.is公印に掛ける(), item.is公印を省略(), item.get県郡名付与区分());
        NinshoshaSource ninshoshaSource = iNinshoshaSourceBuilder.buildSource();
        
        source.hakkoYMD1 = ninshoshaSource.hakkoYMD;
        source.denshiKoin =  ninshoshaSource.denshiKoin;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
        source.bunshoNo = item.getBunshoNo();
        source.tsuchibun1 = item.getTsuchibun1();
        source.shinseiKubun = item.getShinseiKubun();
        source.hokenshaNo1 = item.getHokenshaNo1();
        source.hokenshaNo2 = item.getHokenshaNo2();
        source.hokenshaNo3 = item.getHokenshaNo3();
        source.hokenshaNo4 = item.getHokenshaNo4();
        source.hokenshaNo5 = item.getHokenshaNo5();
        source.hokenshaNo6 = item.getHokenshaNo6();
        source.hihokenshaNo1 = item.getHihokenshaNo1();
        source.hihokenshaNo2 = item.getHihokenshaNo2();
        source.hihokenshaNo3 = item.getHihokenshaNo3();
        source.hihokenshaNo4 = item.getHihokenshaNo4();
        source.hihokenshaNo5 = item.getHihokenshaNo5();
        source.hihokenshaNo6 = item.getHihokenshaNo6();
        source.hihokenshaNo7 = item.getHihokenshaNo7();
        source.hihokenshaNo8 = item.getHihokenshaNo8();
        source.hihokenshaNo9 = item.getHihokenshaNo9();
        source.hihokenshaNo10 = item.getHihokenshaNo10();
        source.shinseiYMD = item.getShinseiYMD();
        source.hihokenshaNameKana = item.getHihokenshaNameKana();
        source.seibetsuMan = item.getSeibetsuMan();
        source.seibetsuWoman = item.getSeibetsuWoman();
        source.hihokenshaName = item.getHihokenshaName();
        source.birthGengoMeiji = item.getBirthGengoMeiji();
        source.birthGengoTaisho = item.getBirthGengoTaisho();
        source.birthGengoShowa = item.getBirthGengoShowa();
        source.birthYMD = item.getBirthYMD();
        source.yubinNo = item.getYubinNo();
        source.jusho = item.getJusho();
        source.tsuchibun2 = item.getTsuchibun2();
        source.remban = item.getRemban();
        return source;
    }

}
