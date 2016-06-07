/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahyoikenshochecklist;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 認定調査結果と主治医意見書のチェックリストのEditorです。
 *
 * @reamsid_L DBE-1390-190 dongyabin
 */
public class ChosahyoIkenshoCheckListEditor implements IChosahyoIkenshoCheckListEditor {

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private final ChosahyoIkenshoCheckListRelateEntity item;

    /**
     * インスタンスを生成します。
     *
     * @param item NinteichosaIraiHenkoData
     */
    protected ChosahyoIkenshoCheckListEditor(ChosahyoIkenshoCheckListRelateEntity item) {
        this.item = item;
    }

    @Override
    public ChosahyoIkenshoCheckListReportSource edit(ChosahyoIkenshoCheckListReportSource source) {
        return editSource(source);
    }

    private ChosahyoIkenshoCheckListReportSource editSource(ChosahyoIkenshoCheckListReportSource source) {
        source.printTimeStamp = get作成年月日時();
        source.hihokenshaNo = item.getDbT5101_hihokenshaNo();
        source.hihokenshaName = item.getDbT5101_hihokenshaName() == null ? RString.EMPTY : item.getDbT5101_hihokenshaName().value();
        source.zenkaiIchijiHanteiKekka = codeTORString(item.getDbT5116Zenkai_ichijiHanteiKekkaCode());
        source.konkaiIchijiHanteiKekka = codeTORString(item.getDbT5116_ichijiHanteiKekkaCode());
        source.shinsakaiKaisaiYMD = dateFormat(item.getDbT5501_shinsakaiKaisaiYoteiYMD());
        source.gogitaiNo = item.getDbT5501_gogitaiNo();
        source.zenkaiNijiHanteiKekka = codeTORString(item.getDbT5102Zenkai_nijiHanteiYokaigoJotaiKubunCode());
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(codeTORString(item.getDbT5101_koroshoIfShikibetsuCode()))) {
            source = editSource09A第１群(source);
            source = editSource09A第１と２群(source);
            source = editSource09A第3群(source);
            source = editSource09A第4群(source);
            source = editSource09A第5群(source);
            source = editSource09A今回調査票(source);
            source = editSource09A今回意見書1(source);
            source = editSource09A今回意見書2(source);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(codeTORString(item.getDbT5101_koroshoIfShikibetsuCode()))) {
            source = editSource09B第１群(source);
            source = editSource09B第１と２群(source);
            source = editSource09B第3群(source);
            source = editSource09B第4群(source);
            source = editSource09B第5群(source);
            source = editSource09B今回調査票(source);
            source = editSource09B今回意見書1(source);
            source = editSource09B今回意見書2(source);
        }
        source.konkaiChosahyo75 = ShogaiNichijoSeikatsuJiritsudoCode.toValue(item.getDbT5203_shogaiNichijoSeikatsuJiritsudoCode().value()).get名称();
        source.konkaiChosahyo76 = NinchishoNichijoSeikatsuJiritsudoCode
                .toValue(item.getDbT5203_ninchishoNichijoSeikatsuJiritsudoCode().value()).get名称();
        source.flag1 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo1, source.konkaiIkensho1);
        source.flag2 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo2, source.konkaiIkensho2);
        source.flag3 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo3, source.konkaiIkensho3);
        source.flag4 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo4, source.konkaiIkensho4);
        source.flag5 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo5, source.konkaiIkensho5);
        source.flag6 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo24, source.konkaiIkensho6);
        source.flag7 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo33, source.konkaiIkensho7);
        source.flag8 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo36, source.konkaiIkensho8);
        source.flag9 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo40, source.konkaiIkensho9);
        source.flag10 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo43, source.konkaiIkensho10);
        source.flag11 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo45, source.konkaiIkensho11);
        source.flag12 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo48, source.konkaiIkensho12);
        source.flag13 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo63, source.konkaiIkensho13);
        source.flag14 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo64, source.konkaiIkensho14);
        source.flag15 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo65, source.konkaiIkensho15);
        source.flag16 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo66, source.konkaiIkensho16);
        source.flag17 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo67, source.konkaiIkensho17);
        source.flag18 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo68, source.konkaiIkensho18);
        source.flag19 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo69, source.konkaiIkensho19);
        source.flag20 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo70, source.konkaiIkensho20);
        source.flag21 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo71, source.konkaiIkensho21);
        source.flag22 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo72, source.konkaiIkensho22);
        source.flag23 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo73, source.konkaiIkensho23);
        source.flag24 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo74, source.konkaiIkensho24);
        source.flag25 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo75, source.konkaiIkensho25);
        source.flag26 = 今回調査票と今回意見書の結果比較(source.konkaiChosahyo76, source.konkaiIkensho26);
        source.shikibetuCode = ShikibetsuCode.EMPTY;
        source.hihokenshaNoAcc = new ExpandedInformation(new Code("100"), new RString("被保険者番号"), item.getDbT5101_hihokenshaNo());
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09A第１群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo1 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.麻痺等_右上肢.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo2 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.麻痺等_左下肢.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo3 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.麻痺等_右下肢.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo4 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.麻痺等_その他.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo5 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.拘縮_肩関節.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo6 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.拘縮_股関節.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo7 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.拘縮_膝関節.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo8 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.拘縮_その他.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo9 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.寝返り.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo10 = ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.起き上がり.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo11 = ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.座位保持.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo12 = ChosaAnser03.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.両足での立位.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo13 = ChosaAnser04.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.歩行.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo14 = ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.立ち上がり.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo15 = ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.片足での立位.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo16 = ChosaAnser04.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.洗身.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo17 = ChosaAnser06.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09A第１と２群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.つめ切り.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo18 = ChosaAnser07.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.視力.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo19 = ChosaAnser08.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.聴力.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo20 = ChosaAnser09.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.移乗.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo21 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.移動.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo22 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.嚥下.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo23 = ChosaAnser11.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.食事摂取.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo24 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.排尿.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo25 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.排便.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo26 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.口腔清潔.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo27 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.洗顔.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo28 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.整髪.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo29 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.上衣の着脱.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo30 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.ズボン等の着脱.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo31 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.外出頻度.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo32 = ChosaAnser13.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09A第3群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.意思の伝達.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo33 = ChosaAnser14.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.毎日の日課を理解.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo34 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.生年月日をいう.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo35 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.短期記憶.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo36 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.自分の名前をいう.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo37 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.今の季節を理解.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo38 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.場所の理解.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo39 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.常時の徘徊.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo40 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.外出して戻れない.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo41 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09A第4群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.被害的.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo42 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.作話.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo43 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.感情が不安定.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo44 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.昼夜逆転.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo45 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.同じ話をする.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo46 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.大声を出す.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo47 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.介護に抵抗.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo48 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.落ち着きなし.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo49 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.一人で出たがる.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo50 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.収集癖.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo51 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.物や衣類を壊す.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo52 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.ひどい物忘れ.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo53 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.独り言_独り笑い.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo54 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.自分勝手に行動する.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo55 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.話がまとまらない.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo56 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09A第5群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.薬の内服.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo57 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.金銭の管理.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo58 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.日常の意思決定.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo59 = ChosaAnser17.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.集団への不適応.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo60 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.買い物.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo61 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.簡単な調理.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo62 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09A今回調査票(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.点滴の管理.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo63 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.中心静脈栄養.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo64 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.透析.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo65 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.ストーマの処置.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo66 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.酸素療法.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo67 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.レスピレーター.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo68 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.気管切開の処置.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo69 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.疼痛の看護.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo70 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.経管栄養.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo71 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.モニター測定.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo72 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.じょくそうの処置.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo73 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09A.カテーテル.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo74 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09A今回意見書1(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5304_remban())) {
            return source;
        }
        if (IkenshoKomokuMapping09A.麻痺_左上肢.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho1 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.麻痺_右上肢.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho2 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.麻痺_左下肢.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho3 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.麻痺_右下肢.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho4 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.麻痺_その他.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho5 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.食事行為.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho6 = IkenKomoku14.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.伝達能力.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho7 = IkenKomoku06.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.短期記憶.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho8 = IkenKomoku04.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.徘徊_認知症の周辺症状.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho9 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.妄想.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho10 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.昼夜逆転.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho11 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.介護への抵抗.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho12 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.点滴の管理.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho13 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09A今回意見書2(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5304_remban())) {
            return source;
        }
        if (IkenshoKomokuMapping09A.中心静脈栄養.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho14 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.透析.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho15 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.ストーマの処置.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho16 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.酸素療法.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho17 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.レスピレーター.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho18 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.気管切開の処置.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho19 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.疼痛の看護.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho20 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.経管栄養.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho21 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.モニター測定.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho22 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.じょくそうの処置.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho23 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.カテーテル.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho24 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.寝たきり度.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho25 = IkenKomoku02.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09A.認知症高齢者の日常生活自立度.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho26 = IkenKomoku03.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09B第１群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo1 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo2 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo3 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo4 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.麻痺等_その他.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo5 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.拘縮_肩関節.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo6 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.拘縮_股関節.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo7 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.拘縮_膝関節.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo8 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.拘縮_その他.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo9 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.寝返り.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo10 = ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.起き上がり.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo11 = ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.座位保持.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo12 = ChosaAnser03.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.両足での立位.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo13 = ChosaAnser04.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.歩行.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo14 = ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.立ち上がり.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo15 = ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.片足での立位.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo16 = ChosaAnser04.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.洗身.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo17 = ChosaAnser06.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09B第１と２群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.つめ切り.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo18 = ChosaAnser07.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.視力.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo19 = ChosaAnser08.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.聴力.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo20 = ChosaAnser09.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.移乗.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo21 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.移動.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo22 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.嚥下.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo23 = ChosaAnser11.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.食事摂取.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo24 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.排尿.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo25 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.排便.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo26 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.口腔清潔.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo27 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.洗顔.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo28 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.整髪.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo29 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.上衣の着脱.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo30 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.ズボン等の着脱.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo31 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.外出頻度.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo32 = ChosaAnser13.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09B第3群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.意思の伝達.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo33 = ChosaAnser14.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.毎日の日課を理解.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo34 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.生年月日をいう.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo35 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.短期記憶.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo36 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.自分の名前をいう.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo37 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.今の季節を理解.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo38 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.場所の理解.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo39 = ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.常時の徘徊.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo40 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.外出して戻れない.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo41 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09B第4群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.被害的.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo42 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.作話.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo43 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.感情が不安定.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo44 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.昼夜逆転.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo45 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.同じ話をする.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo46 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.大声を出す.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo47 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.介護に抵抗.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo48 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.落ち着きなし.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo49 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.一人で出たがる.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo50 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.収集癖.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo51 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.物や衣類を壊す.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo52 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.ひどい物忘れ.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo53 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.独り言_独り笑い.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo54 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.自分勝手に行動する.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo55 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.話がまとまらない.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo56 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09B第5群(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.薬の内服.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo57 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.金銭の管理.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo58 = ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.日常の意思決定.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo59 = ChosaAnser17.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.集団への不適応.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo60 = ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.買い物.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo61 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.簡単な調理.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo62 = ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09B今回調査票(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.点滴の管理.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo63 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.中心静脈栄養.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo64 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.透析.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo65 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.ストーマの処置.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo66 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.酸素療法.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo67 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.レスピレーター.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo68 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.気管切開の処置.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo69 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.疼痛の看護.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo70 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.経管栄養.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo71 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.モニター測定.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo72 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.じょくそうの処置.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo73 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        if (NinteichosaKomokuMapping09B.カテーテル.getコード().equals(item.getDbT5211_remban())) {
            source.konkaiChosahyo74 = ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09B今回意見書1(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5304_remban())) {
            return source;
        }
        if (IkenshoKomokuMapping09B.麻痺_左上肢.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho1 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.麻痺_右上肢.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho2 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.麻痺_左下肢.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho3 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.麻痺_右下肢.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho4 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.麻痺_その他.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho5 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.食事行為.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho6 = IkenKomoku14.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.伝達能力.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho7 = IkenKomoku06.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.短期記憶.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho8 = IkenKomoku04.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.徘徊_認知症の周辺症状.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho9 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.妄想.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho10 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.昼夜逆転.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho11 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.介護への抵抗.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho12 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.点滴の管理.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho13 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportSource editSource09B今回意見書2(ChosahyoIkenshoCheckListReportSource source) {
        if (RString.isNullOrEmpty(item.getDbT5304_remban())) {
            return source;
        }
        if (IkenshoKomokuMapping09B.中心静脈栄養.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho14 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.透析.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho15 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.ストーマの処置.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho16 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.酸素療法.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho17 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.レスピレーター.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho18 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.気管切開の処置.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho19 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.疼痛の看護.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho20 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.経管栄養.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho21 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.モニター測定.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho22 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.じょくそうの処置.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho23 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.カテーテル.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho24 = IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.寝たきり度.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho25 = IkenKomoku02.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        if (IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード().equals(item.getDbT5304_remban())) {
            source.konkaiIkensho26 = IkenKomoku03.toValue(item.getDbT5304_ikenItem()).get名称();
        }
        return source;
    }

    private RString codeTORString(Code code) {
        return code == null ? RString.EMPTY : code.value();
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString 今回調査票と今回意見書の結果比較(RString 今回調査票, RString 今回意見書) {
        if (RString.isNullOrEmpty(今回調査票) && RString.isNullOrEmpty(今回意見書)) {
            return new RString("未");
        } else if (RString.isNullOrEmpty(今回調査票) && !RString.isNullOrEmpty(今回意見書)) {
            return new RString("★");
        } else if (!RString.isNullOrEmpty(今回調査票) && RString.isNullOrEmpty(今回意見書)) {
            return new RString("☆");
        } else if (!RString.isNullOrEmpty(今回調査票) && !RString.isNullOrEmpty(今回意見書)) {
            return RString.EMPTY;
        }
        return RString.EMPTY;
    }

    private RString get作成年月日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        return printTimeStampSb.toRString();
    }
}
