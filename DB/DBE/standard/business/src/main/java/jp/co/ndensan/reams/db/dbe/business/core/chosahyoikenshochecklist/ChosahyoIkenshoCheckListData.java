/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyoikenshochecklist;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListReportEntity;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 認定調査結果と主治医意見書のチェックリストのパラメータを作成クラスです。
 *
 * @reamsid_L DBE-1390-190 dongyabin
 */
public class ChosahyoIkenshoCheckListData {

    private final ChosahyoIkenshoCheckListRelateEntity item;

    /**
     * コンストラクタです。
     *
     * @param item データベースのデータ
     */
    public ChosahyoIkenshoCheckListData(ChosahyoIkenshoCheckListRelateEntity item) {
        this.item = item;
    }

    /**
     * 帳票データを作成します。
     *
     * @param data 帳票データ
     * @return 帳票データ
     */
    public ChosahyoIkenshoCheckListReportEntity get帳票データ(ChosahyoIkenshoCheckListReportEntity data) {
        data.setHihokenshaNo(item.getDbT5101_hihokenshaNo());
        data.setHihokenshaName(item.getDbT5101_hihokenshaName() == null ? RString.EMPTY : item.getDbT5101_hihokenshaName().value());
        data.setZenkaiIchijiHanteiKekka(codeTORString(item.getDbT5116Zenkai_ichijiHanteiKekkaCode()));
        data.setKonkaiIchijiHanteiKekka(codeTORString(item.getDbT5116_ichijiHanteiKekkaCode()));
        data.setShinsakaiKaisaiYMD((dateFormat(item.getDbT5501_shinsakaiKaisaiYoteiYMD())));
        data.setGogitaiNo(item.getDbT5501_gogitaiNo());
        data.setZenkaiNijiHanteiKekka(codeTORString(item.getDbT5102Zenkai_nijiHanteiYokaigoJotaiKubunCode()));
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(codeTORString(item.getDbT5101_koroshoIfShikibetsuCode()))) {
            data = editSource09A第１群(data);
            data = editSource09A第１と２群(data);
            data = editSource09A第3群(data);
            data = editSource09A第4群(data);
            data = editSource09A第5群(data);
            data = editSource09A今回調査票(data);
            data = editSource09A今回意見書1(data);
            data = editSource09A今回意見書2(data);
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(codeTORString(item.getDbT5101_koroshoIfShikibetsuCode()))) {
            data = editSource09B第１群(data);
            data = editSource09B第１と２群(data);
            data = editSource09B第3群(data);
            data = editSource09B第4群(data);
            data = editSource09B第5群(data);
            data = editSource09B今回調査票(data);
            data = editSource09B今回意見書1(data);
            data = editSource09B今回意見書2(data);
        }
        data.setKonkaiChosahyo75(item.getDbT5203_shogaiNichijoSeikatsuJiritsudoCode() == null ? RString.EMPTY
                : ShogaiNichijoSeikatsuJiritsudoCode.toValue(item.getDbT5203_shogaiNichijoSeikatsuJiritsudoCode().value()).get名称());
        data.setKonkaiChosahyo76(item.getDbT5203_ninchishoNichijoSeikatsuJiritsudoCode() == null ? RString.EMPTY
                : NinchishoNichijoSeikatsuJiritsudoCode.toValue(item.getDbT5203_ninchishoNichijoSeikatsuJiritsudoCode().value()).get名称());
        data.setFlag1(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo1(), data.getKonkaiIkensho1()));
        data.setFlag2(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo2(), data.getKonkaiIkensho2()));
        data.setFlag3(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo3(), data.getKonkaiIkensho3()));
        data.setFlag4(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo4(), data.getKonkaiIkensho4()));
        data.setFlag5(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo5(), data.getKonkaiIkensho5()));
        data.setFlag6(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo24(), data.getKonkaiIkensho6()));
        data.setFlag7(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo33(), data.getKonkaiIkensho7()));
        data.setFlag8(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo36(), data.getKonkaiIkensho8()));
        data.setFlag9(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo40(), data.getKonkaiIkensho9()));
        data.setFlag10(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo43(), data.getKonkaiIkensho10()));
        data.setFlag11(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo45(), data.getKonkaiIkensho11()));
        data.setFlag12(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo48(), data.getKonkaiIkensho12()));
        data.setFlag13(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo63(), data.getKonkaiIkensho13()));
        data.setFlag14(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo64(), data.getKonkaiIkensho14()));
        data.setFlag15(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo65(), data.getKonkaiIkensho15()));
        data.setFlag16(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo66(), data.getKonkaiIkensho16()));
        data.setFlag17(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo67(), data.getKonkaiIkensho17()));
        data.setFlag18(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo68(), data.getKonkaiIkensho18()));
        data.setFlag19(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo69(), data.getKonkaiIkensho19()));
        data.setFlag20(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo70(), data.getKonkaiIkensho20()));
        data.setFlag21(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo71(), data.getKonkaiIkensho21()));
        data.setFlag22(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo72(), data.getKonkaiIkensho22()));
        data.setFlag23(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo73(), data.getKonkaiIkensho23()));
        data.setFlag24(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo74(), data.getKonkaiIkensho24()));
        data.setFlag25(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo75(), data.getKonkaiIkensho25()));
        data.setFlag26(今回調査票と今回意見書の結果比較(data.getKonkaiChosahyo76(), data.getKonkaiIkensho26()));
        return data;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09A第１群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.麻痺等_左上肢.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo1(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.麻痺等_右上肢.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo2(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.麻痺等_左下肢.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo3(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.麻痺等_右下肢.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo4(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.麻痺等_その他.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo5(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.拘縮_肩関節.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo6(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.拘縮_股関節.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo7(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.拘縮_膝関節.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo8(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.拘縮_その他.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo9(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.寝返り.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo10(ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.起き上がり.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo11(ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.座位保持.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo12(ChosaAnser03.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.両足での立位.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo13(ChosaAnser04.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.歩行.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo14(ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.立ち上がり.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo15(ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.片足での立位.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo16(ChosaAnser04.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.洗身.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo17(ChosaAnser06.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09A第１と２群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.つめ切り.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo18(ChosaAnser07.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.視力.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo19(ChosaAnser08.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.聴力.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo20(ChosaAnser09.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.移乗.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo21(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.移動.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo22(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.えん下.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo23(ChosaAnser11.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.食事摂取.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo24(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.排尿.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo25(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.排便.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo26(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.口腔清潔.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo27(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.洗顔.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo28(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.整髪.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo29(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.上衣の着脱.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo30(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.ズボン等の着脱.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo31(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.外出頻度.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo32(ChosaAnser13.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09A第3群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.意思の伝達.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo33(ChosaAnser14.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.毎日の日課を理解.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo34(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.生年月日をいう.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo35(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.短期記憶.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo36(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.自分の名前をいう.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo37(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.今の季節を理解.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo38(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.場所の理解.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo39(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.常時の徘徊.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo40(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.外出して戻れない.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo41(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09A第4群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.被害的.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo42(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.作話.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo43(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.感情が不安定.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo44(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.昼夜逆転.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo45(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.同じ話をする.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo46(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.大声を出す.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo47(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.介護に抵抗.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo48(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.落ち着きなし.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo49(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.一人で出たがる.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo50(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.収集癖.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo51(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.物や衣類を壊す.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo52(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.ひどい物忘れ.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo53(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.独り言_独り笑い.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo54(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.自分勝手に行動する.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo55(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.話がまとまらない.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo56(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09A第5群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.薬の内服.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo57(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.金銭の管理.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo58(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.日常の意思決定.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo59(ChosaAnser17.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.集団への不適応.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo60(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.買い物.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo61(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.簡単な調理.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo62(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09A今回調査票(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09A.点滴の管理.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo63(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.中心静脈栄養.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo64(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.透析.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo65(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.ストーマの処置.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo66(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.酸素療法.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo67(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.レスピレーター.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo68(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.気管切開の処置.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo69(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.疼痛の看護.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo70(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.経管栄養.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo71(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.モニター測定.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo72(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.じょくそうの処置.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo73(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09A.カテーテル.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo74(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09A今回意見書1(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5304_remban())) {
            return source;
        }
        if (IkenshoKomokuMapping09A.麻痺_左上肢.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho1(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.麻痺_右上肢.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho2(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.麻痺_左下肢.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho3(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.麻痺_右下肢.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho4(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.麻痺_その他.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho5(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.食事行為.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho6(IkenKomoku14.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.伝達能力.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho7(IkenKomoku06.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.短期記憶.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho8(IkenKomoku04.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.徘徊_認知症の周辺症状.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho9(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.妄想.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho10(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.昼夜逆転.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho11(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.介護への抵抗.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho12(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.点滴の管理.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho13(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09A今回意見書2(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5304_remban())) {
            return source;
        }
        if (IkenshoKomokuMapping09A.中心静脈栄養.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho14(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.透析.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho15(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.ストーマの処置.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho16(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.酸素療法.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho17(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.レスピレーター.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho18(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.気管切開の処置.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho19(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.疼痛の看護.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho20(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.経管栄養.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho21(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.モニター測定.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho22(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.じょくそうの処置.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho23(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.カテーテル.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho24(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.寝たきり度.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho25(IkenKomoku02.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        if (IkenshoKomokuMapping09A.認知症高齢者の日常生活自立度.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho26(IkenKomoku03.toValue(item.getDbT5304_ikenItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09B第１群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo1(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo2(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo3(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo4(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.麻痺等_その他.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo5(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.拘縮_肩関節.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo6(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.拘縮_股関節.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo7(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.拘縮_膝関節.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo8(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.拘縮_その他.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo9(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.寝返り.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo10(ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.起き上がり.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo11(ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.座位保持.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo12(ChosaAnser03.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.両足での立位.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo13(ChosaAnser04.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.歩行.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo14(ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.立ち上がり.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo15(ChosaAnser02.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.片足での立位.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo16(ChosaAnser04.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.洗身.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo17(ChosaAnser06.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09B第１と２群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.つめ切り.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo18(ChosaAnser07.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.視力.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo19(ChosaAnser08.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.聴力.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo20(ChosaAnser09.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.移乗.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo21(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.移動.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo22(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.えん下.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo23(ChosaAnser11.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.食事摂取.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo24(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.排尿.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo25(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.排便.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo26(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.口腔清潔.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo27(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.洗顔.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo28(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.整髪.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo29(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.上衣の着脱.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo30(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.ズボン等の着脱.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo31(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.外出頻度.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo32(ChosaAnser13.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09B第3群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.意思の伝達.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo33(ChosaAnser14.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.毎日の日課を理解.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo34(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.生年月日をいう.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo35(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.短期記憶.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo36(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.自分の名前をいう.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo37(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.今の季節を理解.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo38(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.場所の理解.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo39(ChosaAnser15.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.常時の徘徊.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo40(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.外出して戻れない.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo41(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09B第4群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.被害的.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo42(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.作話.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo43(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.感情が不安定.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo44(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.昼夜逆転.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo45(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.同じ話をする.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo46(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.大声を出す.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo47(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.介護に抵抗.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo48(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.落ち着きなし.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo49(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.一人で出たがる.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo50(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.収集癖.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo51(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.物や衣類を壊す.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo52(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.ひどい物忘れ.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo53(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.独り言_独り笑い.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo54(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.自分勝手に行動する.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo55(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.話がまとまらない.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo56(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09B第5群(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.薬の内服.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo57(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.金銭の管理.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo58(ChosaAnser12.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.日常の意思決定.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo59(ChosaAnser17.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.集団への不適応.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo60(ChosaAnser16.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.買い物.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo61(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.簡単な調理.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo62(ChosaAnser10.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09B今回調査票(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5211_remban())) {
            return source;
        }
        if (NinteichosaKomokuMapping09B.点滴の管理.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo63(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.中心静脈栄養.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo64(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.透析.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo65(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.ストーマの処置.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo66(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.酸素療法.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo67(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.レスピレーター.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo68(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.気管切開の処置.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo69(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.疼痛の看護.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo70(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.経管栄養.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo71(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.モニター測定.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo72(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.じょくそうの処置.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo73(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        if (NinteichosaKomokuMapping09B.カテーテル.getコード().equals(item.getDbT5211_remban())) {
            source.setKonkaiChosahyo74(ChosaAnser01.toValue(item.getDbT5211_researchItem()).get名称());
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09B今回意見書1(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5304_remban())) {
            return source;
        }
        if (IkenshoKomokuMapping09B.麻痺_左上肢.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho1(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.麻痺_右上肢.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho2(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.麻痺_左下肢.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho3(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.麻痺_右下肢.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho4(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.麻痺_その他.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho5(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.食事行為.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho6(IkenKomoku14.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.伝達能力.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho7(IkenKomoku06.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.短期記憶.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho8(IkenKomoku04.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.徘徊_認知症の周辺症状.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho9(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.妄想.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho10(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.昼夜逆転.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho11(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.介護への抵抗.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho12(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.点滴の管理.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho13(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        return source;
    }

    private ChosahyoIkenshoCheckListReportEntity editSource09B今回意見書2(ChosahyoIkenshoCheckListReportEntity source) {
        if (RString.isNullOrEmpty(item.getDbT5304_remban())) {
            return source;
        }
        if (IkenshoKomokuMapping09B.中心静脈栄養.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho14(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.透析.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho15(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.ストーマの処置.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho16(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.酸素療法.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho17(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.レスピレーター.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho18(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.気管切開の処置.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho19(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.疼痛の看護.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho20(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.経管栄養.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho21(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.モニター測定.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho22(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.じょくそうの処置.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho23(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.カテーテル.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho24(IkenKomoku01.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.寝たきり度.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho25(IkenKomoku02.toValue(item.getDbT5304_ikenItem()).get名称()
            );
        }
        if (IkenshoKomokuMapping09B.認知症高齢者の日常生活自立度.getコード().equals(item.getDbT5304_remban())) {
            source.setKonkaiIkensho26(IkenKomoku03.toValue(item.getDbT5304_ikenItem()).get名称()
            );
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
}
