/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.fukadaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.report.fukadaicho.FukaDaichoSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 賦課台帳（本算定）帳票FukaDaichoReport
 *
 * @reamsid_L DBB-9100-030 surun
 */
public class FukaDaichoReport extends Report<FukaDaichoSource> {

    private static final int INDEX1 = 1;
    private static final int INDEX2 = 2;
    private static final int INDEX3 = 3;
    private static final int INDEX4 = 4;
    private static final int INDEX5 = 5;
    private static final int INDEX6 = 6;
    private static final int INDEX7 = 7;
    private static final int INDEX0 = 0;
    private static final int PAGERECORDS = 8;
    private final EditedHonSanteiFukaDaichoJoho entity;

    /**
     * コンストラクタです。
     *
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    public FukaDaichoReport(EditedHonSanteiFukaDaichoJoho entity) {
        this.entity = entity;
    }

    @Override
    public void writeBy(ReportSourceWriter<FukaDaichoSource> writer) {
        List<FukaDaichoItem> targets = setItems(entity);
        for (FukaDaichoItem target : targets) {
            IFukaDaichoEditor headerEditor = new FukaDaichoHeaderEditor(target);
            IFukaDaichoEditor bodyEditor = new FukaDaichoBodyEditor(target);
            IFukaDaichoBuilder builder = new FukaDaichoBuilder(headerEditor, bodyEditor);
            writer.writeLine(builder);
        }
    }

    /**
     * setItemsメソッド
     *
     * @param entity EditedHonSanteiFukaDaichoJoho
     * @return List<FukaDaichoItem>
     */
    private List<FukaDaichoItem> setItems(EditedHonSanteiFukaDaichoJoho entity) {
        List<FukaDaichoItem> targets = new ArrayList<>();
        Integer pageAll = 1;
        if (entity == null) {
            FukaDaichoItem item = new FukaDaichoItem();
            targets.add(item);
            return targets;
        }
        if (!entity.get世帯員情報リスト().isEmpty()) {
            pageAll = (entity.get世帯員情報リスト().size() - 1) / PAGERECORDS + 1;
        }
        for (int pageNow = 1; pageNow <= pageAll; pageNow++) {
            if (pageNow <= 1) {
                FukaDaichoItem item = new FukaDaichoItem();
                setItemBase(item, entity);
                setHonSanteifukaUchiwakeNiKoseiAtoShotokuDankai(item, entity);
                setFutsuChoshuShunyuKingaku(item, entity);
                setTokubetsuChoshuShunyuKingaku(item, entity);

                FukaDaichoItem item2 = new FukaDaichoItem();
                setHonSanteifukaUchiwakeIchiKoseiMae(item2, entity);
                setHonSanteifukaUchiwakeNiKoseiMaeNengakuHokenryo(item2, entity);
                if (has普通徴収情報(entity) && GennenKanen.過年度 != entity.get年度区分()) {
                    setFutsuChoshuKoseiMae(item2, entity);
                }
                setHonninKoseiMae(item2, entity);
                if (has特別徴収情報(entity)) {
                    setTokubetsuChoshuKoseiMae(item2, entity);
                }
                setTokubetsuChoshuKi(item2, entity);
                setTokubetsuChoshuTsuki(item2, entity);

                setFutsuChoshuKi(item2, entity);
                setFutsuChoshuTsuki(item2, entity);
                setFutsuChoshuZuiji(item2, entity);

                FukaDaichoItem item3 = new FukaDaichoItem();
                setHonSanteifukaUchiwakeIchiKoseiAto(item3, entity);
                setHonSanteifukaUchiwakeNiKoseiMaeShotokuDankai(item3, entity);
                if (has普通徴収情報(entity)) {
                    setFutsuChoshuKoseiAto(item3, entity);
                }
                setHonninKoseiAto(item3, entity);
                if (has特別徴収情報(entity)) {
                    setTokubetsuChoshuKoseiAto(item3, entity);
                }

                FukaDaichoItem item4 = new FukaDaichoItem();
                setHonSanteifukaUchiwakeIchiZogenKingaku(item4, entity);
                setHonSanteifukaUchiwakeNiKoseiAtoNengakuHokenryo(item4, entity);
                if (has普通徴収情報(entity)) {
                    setFutsuChoshuZogenKingaku(item4, entity);
                }
                if (has特別徴収情報(entity)) {
                    setTokubetsuChoshuZogenKingaku(item4, entity);
                }

                set世帯員情報リストPart1(item2, entity, INDEX0);
                set世帯員情報リストPart2(item2, entity, INDEX4);
                set世帯員情報リストPart1(item3, entity, INDEX1);
                set世帯員情報リストPart2(item3, entity, INDEX5);
                set世帯員情報リストPart1(item4, entity, INDEX2);
                set世帯員情報リストPart2(item4, entity, INDEX6);
                set世帯員情報リストPart1(item, entity, INDEX3);
                set世帯員情報リストPart2(item, entity, INDEX7);

                item.setPageNo(new RString(pageNow));
                item.setPageNoAll(new RString(pageAll));
                item.setPrintTimeStamp(entity.get印刷日時());
                item.setSetaiCode(entity.get世帯コード());
                item.setTitle(entity.getタイトル());
                item.setTsuchishoNo(entity.get通知書NO());

                targets.add(item2);
                targets.add(item3);
                targets.add(item4);
                targets.add(item);
            } else {
                int start = (pageNow - 1) * PAGERECORDS;
                int end = Math.min(entity.get世帯員情報リスト().size(), pageNow * PAGERECORDS - 1);
                for (int i = start; i < end; i++) {
                    FukaDaichoItem newRecord = new FukaDaichoItem();
                    newRecord.setTitle(entity.getタイトル());
                    newRecord.setChoteiNendo(entity.get調定年度());
                    newRecord.setFukaNendo(entity.get賦課年度());
                    newRecord.setPrintTimeStamp(entity.get印刷日時());
                    newRecord.setPageNo(new RString(pageNow));
                    newRecord.setPageNoAll(new RString(pageAll.toString()));
                    newRecord.setHokenshaNo(entity.get保険者番号().value());
                    newRecord.setHokenshaName(entity.get保険者名称());
                    newRecord.setTsuchishoNo(entity.get通知書NO());
                    newRecord.setHihokenshaNo(entity.get被保険者番号().value());
                    newRecord.setSetaiCode(entity.get世帯コード());
                    set世帯員情報リストPart1(newRecord, entity, i);
                    set世帯員情報リストPart2(newRecord, entity, ++i);
                    targets.add(newRecord);
                }
            }
        }
        return targets;
    }

    private boolean has普通徴収情報(EditedHonSanteiFukaDaichoJoho entity) {
        RString 更正前確定年額保険料 = RString.EMPTY;
        RString 更正後確定年額保険料 = RString.EMPTY;
        if (entity.get普通徴収更正前() != null) {
            更正前確定年額保険料 = entity.get普通徴収更正前().get普徴確定年額保険料();
            更正後確定年額保険料 = entity.get普通徴収更正後().get普徴確定年額保険料();
        }
        return !((RString.isNullOrEmpty(更正前確定年額保険料) || 更正前確定年額保険料.equals(new RString("0")))
                && (RString.isNullOrEmpty(更正後確定年額保険料) || 更正後確定年額保険料.equals(new RString("0"))));
    }

    private boolean has特別徴収情報(EditedHonSanteiFukaDaichoJoho entity) {
        RString 更正前確定年額保険料 = RString.EMPTY;
        RString 更正後確定年額保険料 = RString.EMPTY;
        if (entity.get特別徴収更正前() != null) {
            更正前確定年額保険料 = entity.get特別徴収更正前().get特徴確定年額保険料();
            更正後確定年額保険料 = entity.get特別徴収更正後().get特徴確定年額保険料();
        }
        return !((RString.isNullOrEmpty(更正前確定年額保険料) || 更正前確定年額保険料.equals(new RString("0")))
                && (RString.isNullOrEmpty(更正後確定年額保険料) || 更正後確定年額保険料.equals(new RString("0"))));
    }

    /**
     * set特別徴収更正前
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setTokubetsuChoshuKoseiMae(FukaDaichoItem item, EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get特別徴収更正前() != null) {
            item.setListTokuChoshu_1(entity.get特別徴収更正前().get特徴調定月());
            item.setListTokuChoshu_10(entity.get特別徴収更正前().get特徴金額５());
            item.setListTokuChoshu_11(entity.get特別徴収更正前().get特徴金額６());
            item.setListTokuChoshu_12(entity.get特別徴収更正前().get特徴金額７());
            item.setListTokuChoshu_13(entity.get特別徴収更正前().get特徴金額８());
            item.setListTokuChoshu_14(entity.get特別徴収更正前().get特徴金額９());
            item.setListTokuChoshu_15(entity.get特別徴収更正前().get特徴金額１０());
            item.setListTokuChoshu_16(entity.get特別徴収更正前().get特徴金額１１());
            item.setListTokuChoshu_17(entity.get特別徴収更正前().get特徴金額１２());
            item.setListTokuChoshu_18(entity.get特別徴収更正前().get特徴金額１３());
            item.setListTokuChoshu_19(entity.get特別徴収更正前().get特徴金額１４());
            item.setListTokuChoshu_20(entity.get特別徴収更正前().get調整額歳出還付());
            item.setListTokuChoshu_2(entity.get特別徴収更正前().get特徴調定月の期());
            item.setListTokuChoshu_3(entity.get特別徴収更正前().get特徴確定年額保険料());
            item.setListTokuChoshu_4(entity.get特別徴収更正前().get特徴納付済額());
            item.setListTokuChoshu_5(entity.get特別徴収更正前().get特徴今後納付すべき額());
            item.setListTokuChoshu_6(entity.get特別徴収更正前().get特徴金額１());
            item.setListTokuChoshu_7(entity.get特別徴収更正前().get特徴金額２());
            item.setListTokuChoshu_8(entity.get特別徴収更正前().get特徴金額３());
            item.setListTokuChoshu_9(entity.get特別徴収更正前().get特徴金額４());
        }
    }

    /**
     * set特別徴収更正後
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setTokubetsuChoshuKoseiAto(FukaDaichoItem item, EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get特別徴収更正後() != null) {
            item.setListTokuChoshu_1(entity.get特別徴収更正後().get特徴調定月());
            item.setListTokuChoshu_10(entity.get特別徴収更正後().get特徴金額５());
            item.setListTokuChoshu_11(entity.get特別徴収更正後().get特徴金額６());
            item.setListTokuChoshu_12(entity.get特別徴収更正後().get特徴金額７());
            item.setListTokuChoshu_13(entity.get特別徴収更正後().get特徴金額８());
            item.setListTokuChoshu_14(entity.get特別徴収更正後().get特徴金額９());
            item.setListTokuChoshu_15(entity.get特別徴収更正後().get特徴金額１０());
            item.setListTokuChoshu_16(entity.get特別徴収更正後().get特徴金額１１());
            item.setListTokuChoshu_17(entity.get特別徴収更正後().get特徴金額１２());
            item.setListTokuChoshu_18(entity.get特別徴収更正後().get特徴金額１３());
            item.setListTokuChoshu_19(entity.get特別徴収更正後().get特徴金額１４());
            item.setListTokuChoshu_20(entity.get特別徴収更正後().get調整額歳出還付());
            item.setListTokuChoshu_2(entity.get特別徴収更正後().get特徴調定月の期());
            item.setListTokuChoshu_3(entity.get特別徴収更正後().get特徴確定年額保険料());
            item.setListTokuChoshu_4(entity.get特別徴収更正後().get特徴納付済額());
            item.setListTokuChoshu_5(entity.get特別徴収更正後().get特徴今後納付すべき額());
            item.setListTokuChoshu_6(entity.get特別徴収更正後().get特徴金額１());
            item.setListTokuChoshu_7(entity.get特別徴収更正後().get特徴金額２());
            item.setListTokuChoshu_8(entity.get特別徴収更正後().get特徴金額３());
            item.setListTokuChoshu_9(entity.get特別徴収更正後().get特徴金額４());
        }
    }

    /**
     * set特別徴収増減額
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setTokubetsuChoshuZogenKingaku(FukaDaichoItem item, EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get特別徴収増減額() != null) {
            item.setListTokuChoshu_1(entity.get特別徴収増減額().get特徴調定月());
            item.setListTokuChoshu_10(entity.get特別徴収増減額().get特徴金額５());
            item.setListTokuChoshu_11(entity.get特別徴収増減額().get特徴金額６());
            item.setListTokuChoshu_12(entity.get特別徴収増減額().get特徴金額７());
            item.setListTokuChoshu_13(entity.get特別徴収増減額().get特徴金額８());
            item.setListTokuChoshu_14(entity.get特別徴収増減額().get特徴金額９());
            item.setListTokuChoshu_15(entity.get特別徴収増減額().get特徴金額１０());
            item.setListTokuChoshu_16(entity.get特別徴収増減額().get特徴金額１１());
            item.setListTokuChoshu_17(entity.get特別徴収増減額().get特徴金額１２());
            item.setListTokuChoshu_18(entity.get特別徴収増減額().get特徴金額１３());
            item.setListTokuChoshu_19(entity.get特別徴収増減額().get特徴金額１４());
            item.setListTokuChoshu_20(entity.get特別徴収増減額().get調整額歳出還付());
            item.setListTokuChoshu_2(entity.get特別徴収増減額().get特徴調定月の期());
            item.setListTokuChoshu_3(entity.get特別徴収増減額().get特徴確定年額保険料());
            item.setListTokuChoshu_4(entity.get特別徴収増減額().get特徴納付済額());
            item.setListTokuChoshu_5(entity.get特別徴収増減額().get特徴今後納付すべき額());
            item.setListTokuChoshu_6(entity.get特別徴収増減額().get特徴金額１());
            item.setListTokuChoshu_7(entity.get特別徴収増減額().get特徴金額２());
            item.setListTokuChoshu_8(entity.get特別徴収増減額().get特徴金額３());
            item.setListTokuChoshu_9(entity.get特別徴収増減額().get特徴金額４());
        }
    }

    /**
     * set特別徴収収入額
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setTokubetsuChoshuShunyuKingaku(FukaDaichoItem item, EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get特別徴収収入額() != null) {
            item.setListTokuChoshu_10(entity.get特別徴収収入額().get特徴金額５());
            item.setListTokuChoshu_11(entity.get特別徴収収入額().get特徴金額６());
            item.setListTokuChoshu_12(entity.get特別徴収収入額().get特徴金額７());
            item.setListTokuChoshu_13(entity.get特別徴収収入額().get特徴金額８());
            item.setListTokuChoshu_14(entity.get特別徴収収入額().get特徴金額９());
            item.setListTokuChoshu_15(entity.get特別徴収収入額().get特徴金額１０());
            item.setListTokuChoshu_16(entity.get特別徴収収入額().get特徴金額１１());
            item.setListTokuChoshu_17(entity.get特別徴収収入額().get特徴金額１２());
            item.setListTokuChoshu_18(entity.get特別徴収収入額().get特徴金額１３());
            item.setListTokuChoshu_19(entity.get特別徴収収入額().get特徴金額１４());
            item.setListTokuChoshu_20(entity.get特別徴収収入額().get調整額歳出還付());
            item.setListTokuChoshu_3(entity.get特別徴収収入額().get特徴確定年額保険料());
            item.setListTokuChoshu_4(entity.get特別徴収収入額().get特徴納付済額());
            item.setListTokuChoshu_5(entity.get特別徴収収入額().get特徴今後納付すべき額());
            item.setListTokuChoshu_6(entity.get特別徴収収入額().get特徴金額１());
            item.setListTokuChoshu_7(entity.get特別徴収収入額().get特徴金額２());
            item.setListTokuChoshu_8(entity.get特別徴収収入額().get特徴金額３());
            item.setListTokuChoshu_9(entity.get特別徴収収入額().get特徴金額４());
        }
    }

    /**
     * set普通徴収更正前
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setFutsuChoshuKoseiMae(FukaDaichoItem item, EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get普通徴収更正前() != null) {
            item.setListFutsuChoshu_1(entity.get普通徴収更正前().get普徴調定月());
            item.setListFutsuChoshu_10(entity.get普通徴収更正前().get普徴金額５());
            item.setListFutsuChoshu_11(entity.get普通徴収更正前().get普徴金額６());
            item.setListFutsuChoshu_12(entity.get普通徴収更正前().get普徴金額７());
            item.setListFutsuChoshu_13(entity.get普通徴収更正前().get普徴金額８());
            item.setListFutsuChoshu_14(entity.get普通徴収更正前().get普徴金額９());
            item.setListFutsuChoshu_15(entity.get普通徴収更正前().get普徴金額１０());
            item.setListFutsuChoshu_16(entity.get普通徴収更正前().get普徴金額１１());
            item.setListFutsuChoshu_17(entity.get普通徴収更正前().get普徴金額１２());
            item.setListFutsuChoshu_18(entity.get普通徴収更正前().get普徴金額１３());
            item.setListFutsuChoshu_19(entity.get普通徴収更正前().get普徴金額１４());
            item.setListFutsuChoshu_2(entity.get普通徴収更正前().get普徴調定月の期());
            item.setListFutsuChoshu_20(entity.get普通徴収更正前().get調整額歳出還付());
            item.setListFutsuChoshu_3(entity.get普通徴収更正前().get普徴確定年額保険料());
            item.setListFutsuChoshu_4(entity.get普通徴収更正前().get普徴納付済額());
            item.setListFutsuChoshu_5(entity.get普通徴収更正前().get普徴今後納付すべき額());
            item.setListFutsuChoshu_6(entity.get普通徴収更正前().get普徴金額１());
            item.setListFutsuChoshu_7(entity.get普通徴収更正前().get普徴金額２());
            item.setListFutsuChoshu_8(entity.get普通徴収更正前().get普徴金額３());
            item.setListFutsuChoshu_9(entity.get普通徴収更正前().get普徴金額４());
        }
    }

    /**
     * set普通徴収更正後
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setFutsuChoshuKoseiAto(FukaDaichoItem item, EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get普通徴収更正後() != null) {
            item.setListFutsuChoshu_1(entity.get普通徴収更正後().get普徴調定月());
            item.setListFutsuChoshu_10(entity.get普通徴収更正後().get普徴金額５());
            item.setListFutsuChoshu_11(entity.get普通徴収更正後().get普徴金額６());
            item.setListFutsuChoshu_12(entity.get普通徴収更正後().get普徴金額７());
            item.setListFutsuChoshu_13(entity.get普通徴収更正後().get普徴金額８());
            item.setListFutsuChoshu_14(entity.get普通徴収更正後().get普徴金額９());
            item.setListFutsuChoshu_15(entity.get普通徴収更正後().get普徴金額１０());
            item.setListFutsuChoshu_16(entity.get普通徴収更正後().get普徴金額１１());
            item.setListFutsuChoshu_17(entity.get普通徴収更正後().get普徴金額１２());
            item.setListFutsuChoshu_18(entity.get普通徴収更正後().get普徴金額１３());
            item.setListFutsuChoshu_19(entity.get普通徴収更正後().get普徴金額１４());
            item.setListFutsuChoshu_2(entity.get普通徴収更正後().get普徴調定月の期());
            item.setListFutsuChoshu_20(entity.get普通徴収更正後().get調整額歳出還付());
            item.setListFutsuChoshu_3(entity.get普通徴収更正後().get普徴確定年額保険料());
            item.setListFutsuChoshu_4(entity.get普通徴収更正後().get普徴納付済額());
            item.setListFutsuChoshu_5(entity.get普通徴収更正後().get普徴今後納付すべき額());
            item.setListFutsuChoshu_6(entity.get普通徴収更正後().get普徴金額１());
            item.setListFutsuChoshu_7(entity.get普通徴収更正後().get普徴金額２());
            item.setListFutsuChoshu_8(entity.get普通徴収更正後().get普徴金額３());
            item.setListFutsuChoshu_9(entity.get普通徴収更正後().get普徴金額４());
        }
    }

    /**
     * set普通徴収増減額
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setFutsuChoshuZogenKingaku(FukaDaichoItem item, EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get普通徴収増減額() != null) {
            item.setListFutsuChoshu_1(entity.get普通徴収増減額().get普徴調定月());
            item.setListFutsuChoshu_2(entity.get普通徴収増減額().get普徴調定月の期());
            item.setListFutsuChoshu_3(entity.get普通徴収増減額().get普徴確定年額保険料());
            item.setListFutsuChoshu_4(entity.get普通徴収増減額().get普徴納付済額());
            item.setListFutsuChoshu_5(entity.get普通徴収増減額().get普徴今後納付すべき額());
            item.setListFutsuChoshu_6(entity.get普通徴収増減額().get普徴金額１());
            item.setListFutsuChoshu_7(entity.get普通徴収増減額().get普徴金額２());
            item.setListFutsuChoshu_8(entity.get普通徴収増減額().get普徴金額３());
            item.setListFutsuChoshu_9(entity.get普通徴収増減額().get普徴金額４());
            item.setListFutsuChoshu_10(entity.get普通徴収増減額().get普徴金額５());
            item.setListFutsuChoshu_11(entity.get普通徴収増減額().get普徴金額６());
            item.setListFutsuChoshu_12(entity.get普通徴収増減額().get普徴金額７());
            item.setListFutsuChoshu_13(entity.get普通徴収増減額().get普徴金額８());
            item.setListFutsuChoshu_14(entity.get普通徴収増減額().get普徴金額９());
            item.setListFutsuChoshu_15(entity.get普通徴収増減額().get普徴金額１０());
            item.setListFutsuChoshu_16(entity.get普通徴収増減額().get普徴金額１１());
            item.setListFutsuChoshu_17(entity.get普通徴収増減額().get普徴金額１２());
            item.setListFutsuChoshu_18(entity.get普通徴収増減額().get普徴金額１３());
            item.setListFutsuChoshu_19(entity.get普通徴収増減額().get普徴金額１４());
            item.setListFutsuChoshu_20(entity.get普通徴収増減額().get調整額歳出還付());
        }
    }

    /**
     * set普通徴収収入額
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setFutsuChoshuShunyuKingaku(FukaDaichoItem item, EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get普通徴収収入額() != null) {
            item.setListFutsuChoshu_10(entity.get普通徴収収入額().get普徴金額５());
            item.setListFutsuChoshu_11(entity.get普通徴収収入額().get普徴金額６());
            item.setListFutsuChoshu_12(entity.get普通徴収収入額().get普徴金額７());
            item.setListFutsuChoshu_13(entity.get普通徴収収入額().get普徴金額８());
            item.setListFutsuChoshu_14(entity.get普通徴収収入額().get普徴金額９());
            item.setListFutsuChoshu_15(entity.get普通徴収収入額().get普徴金額１０());
            item.setListFutsuChoshu_16(entity.get普通徴収収入額().get普徴金額１１());
            item.setListFutsuChoshu_17(entity.get普通徴収収入額().get普徴金額１２());
            item.setListFutsuChoshu_18(entity.get普通徴収収入額().get普徴金額１３());
            item.setListFutsuChoshu_19(entity.get普通徴収収入額().get普徴金額１４());
            item.setListFutsuChoshu_20(entity.get普通徴収収入額().get調整額歳出還付());
            item.setListFutsuChoshu_3(entity.get普通徴収収入額().get普徴確定年額保険料());
            item.setListFutsuChoshu_4(entity.get普通徴収収入額().get普徴納付済額());
            item.setListFutsuChoshu_5(entity.get普通徴収収入額().get普徴今後納付すべき額());
            item.setListFutsuChoshu_6(entity.get普通徴収収入額().get普徴金額１());
            item.setListFutsuChoshu_7(entity.get普通徴収収入額().get普徴金額２());
            item.setListFutsuChoshu_8(entity.get普通徴収収入額().get普徴金額３());
            item.setListFutsuChoshu_9(entity.get普通徴収収入額().get普徴金額４());
        }
    }

    /**
     * set本算定賦課内訳１（更正前）
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonSanteifukaUchiwakeIchiKoseiMae(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本算定賦課内訳１更正前() != null) {
            item.setListFukaUchiwake1_1(entity.get本算定賦課内訳１更正前().get本人合計所得金額());
            item.setListFukaUchiwake1_2(entity.get本算定賦課内訳１更正前().get本人公的年金収入額());
            item.setListFukaUchiwake1_3(entity.get本算定賦課内訳１更正前().get本人課税区分());
            item.setListFukaUchiwake1_4(entity.get本算定賦課内訳１更正前().get世帯課税区分());
            item.setListFukaUchiwake1_5(entity.get本算定賦課内訳１更正前().get本人算出保険料額());
            item.setListFukaUchiwake1_6(entity.get本算定賦課内訳１更正前().get本人減免額());
            item.setListFukaUchiwake1_7(entity.get本算定賦課内訳１更正前().get確定年額保険料());
            item.setListFukaUchiwake1_8(entity.get本算定賦課内訳１更正前().get賦課基準日());
            item.setListFukaUchiwake1_9(entity.get本算定賦課内訳１更正前().get調定年月日());
        }

    }

    /**
     * set本算定賦課内訳１（更正後）
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonSanteifukaUchiwakeIchiKoseiAto(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本算定賦課内訳１更正後() != null) {
            item.setListFukaUchiwake1_1(entity.get本算定賦課内訳１更正後().get本人合計所得金額());
            item.setListFukaUchiwake1_2(entity.get本算定賦課内訳１更正後().get本人公的年金収入額());
            item.setListFukaUchiwake1_3(entity.get本算定賦課内訳１更正後().get本人課税区分());
            item.setListFukaUchiwake1_4(entity.get本算定賦課内訳１更正後().get世帯課税区分());
            item.setListFukaUchiwake1_5(entity.get本算定賦課内訳１更正後().get本人算出保険料額());
            item.setListFukaUchiwake1_6(entity.get本算定賦課内訳１更正後().get本人減免額());
            item.setListFukaUchiwake1_7(entity.get本算定賦課内訳１更正後().get確定年額保険料());
            item.setListFukaUchiwake1_8(entity.get本算定賦課内訳１更正後().get賦課基準日());
            item.setListFukaUchiwake1_9(entity.get本算定賦課内訳１更正後().get調定年月日());
        }
    }

    /**
     * set本算定賦課内訳１（増減額）
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonSanteifukaUchiwakeIchiZogenKingaku(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本算定賦課内訳１増減額() != null) {
            item.setListFukaUchiwake1_1(entity.get本算定賦課内訳１増減額().get本人合計所得金額());
            item.setListFukaUchiwake1_2(entity.get本算定賦課内訳１増減額().get本人公的年金収入額());
            item.setListFukaUchiwake1_5(entity.get本算定賦課内訳１増減額().get本人算出保険料額());
            item.setListFukaUchiwake1_6(entity.get本算定賦課内訳１増減額().get本人減免額());
            item.setListFukaUchiwake1_7(entity.get本算定賦課内訳１増減額().get確定年額保険料());
        }
    }

    /**
     * set本算定賦課内訳２更正前年額保険料
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonSanteifukaUchiwakeNiKoseiMaeNengakuHokenryo(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本算定賦課内訳２更正前年額保険料() != null) {
            item.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正前年額保険料().get四月分保険料額());
            item.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正前年額保険料().get一月分保険料額());
            item.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正前年額保険料().get二月分保険料額());
            item.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正前年額保険料().get三月分保険料額());
            item.setListFukaUchiwake2_13(entity.get本算定賦課内訳２更正前年額保険料().get十二ヶ月分年度加算額());
            item.setListFukaUchiwake2_14(entity.get本算定賦課内訳２更正前年額保険料().get公式());
            item.setListFukaUchiwake2_15(entity.get本算定賦課内訳２更正前年額保険料().get月割年額保険料額());
            item.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正前年額保険料().get五月分保険料額());
            item.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正前年額保険料().get六月分保険料額());
            item.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正前年額保険料().get七月分保険料額());
            item.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正前年額保険料().get八月分保険料額());
            item.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正前年額保険料().get九月分保険料額());
            item.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正前年額保険料().get十月分保険料額());
            item.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正前年額保険料().get十一月分保険料額());
            item.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正前年額保険料().get十二月分保険料額());
        }
    }

    /**
     * set本算定賦課内訳２（更正前）所得段階
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonSanteifukaUchiwakeNiKoseiMaeShotokuDankai(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本算定賦課内訳２更正前所得段階() != null) {
            item.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正前所得段階().get四月分所得段階());
            item.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正前所得段階().get五月分所得段階());
            item.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正前所得段階().get六月分所得段階());
            item.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正前所得段階().get七月分所得段階());
            item.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正前所得段階().get八月分所得段階());
            item.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正前所得段階().get九月分所得段階());
            item.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正前所得段階().get十月分所得段階());
            item.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正前所得段階().get十一月分所得段階());
            item.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正前所得段階().get十二月分所得段階());
            item.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正前所得段階().get一月分所得段階());
            item.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正前所得段階().get二月分所得段階());
            item.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正前所得段階().get三月分所得段階());
        }
    }

    /**
     * set本算定賦課内訳２（更正後）年額保険料
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonSanteifukaUchiwakeNiKoseiAtoNengakuHokenryo(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本算定賦課内訳２更正後年額保険料() != null) {
            item.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正後年額保険料().get四月分保険料額());
            item.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正後年額保険料().get一月分保険料額());
            item.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正後年額保険料().get二月分保険料額());
            item.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正後年額保険料().get三月分保険料額());
            item.setListFukaUchiwake2_13(entity.get本算定賦課内訳２更正後年額保険料().get十二ヶ月分年度加算額());
            item.setListFukaUchiwake2_14(entity.get本算定賦課内訳２更正後年額保険料().get公式());
            item.setListFukaUchiwake2_15(entity.get本算定賦課内訳２更正後年額保険料().get月割年額保険料額());
            item.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正後年額保険料().get五月分保険料額());
            item.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正後年額保険料().get六月分保険料額());
            item.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正後年額保険料().get七月分保険料額());
            item.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正後年額保険料().get八月分保険料額());
            item.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正後年額保険料().get九月分保険料額());
            item.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正後年額保険料().get十月分保険料額());
            item.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正後年額保険料().get十一月分保険料額());
            item.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正後年額保険料().get十二月分保険料額());
        }
    }

    /**
     * set本算定賦課内訳２（更正後）所得段階
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonSanteifukaUchiwakeNiKoseiAtoShotokuDankai(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本算定賦課内訳２更正後所得段階() != null) {
            item.setListFukaUchiwake2_1(entity.get本算定賦課内訳２更正後所得段階().get四月分所得段階());
            item.setListFukaUchiwake2_2(entity.get本算定賦課内訳２更正後所得段階().get五月分所得段階());
            item.setListFukaUchiwake2_3(entity.get本算定賦課内訳２更正後所得段階().get六月分所得段階());
            item.setListFukaUchiwake2_4(entity.get本算定賦課内訳２更正後所得段階().get七月分所得段階());
            item.setListFukaUchiwake2_5(entity.get本算定賦課内訳２更正後所得段階().get八月分所得段階());
            item.setListFukaUchiwake2_6(entity.get本算定賦課内訳２更正後所得段階().get九月分所得段階());
            item.setListFukaUchiwake2_7(entity.get本算定賦課内訳２更正後所得段階().get十月分所得段階());
            item.setListFukaUchiwake2_8(entity.get本算定賦課内訳２更正後所得段階().get十一月分所得段階());
            item.setListFukaUchiwake2_9(entity.get本算定賦課内訳２更正後所得段階().get十二月分所得段階());
            item.setListFukaUchiwake2_10(entity.get本算定賦課内訳２更正後所得段階().get一月分所得段階());
            item.setListFukaUchiwake2_11(entity.get本算定賦課内訳２更正後所得段階().get二月分所得段階());
            item.setListFukaUchiwake2_12(entity.get本算定賦課内訳２更正後所得段階().get三月分所得段階());
        }
    }

    /**
     * set本人（更正前）
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonninKoseiMae(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本人更正前() != null) {
            item.setListHonin1_1(entity.get本人更正前().get本人資格取得日());
            item.setListHonin1_2(entity.get本人更正前().get本人取得事由());
            item.setListHonin1_3(entity.get本人更正前().get本人資格喪失日());
            item.setListHonin1_4(entity.get本人更正前().get本人喪失事由());
            item.setListHonin1_6(entity.get本人更正前().get本人生活保護開始年月日());
            item.setListHonin1_7(entity.get本人更正前().get本人生活保護終了年月日());
            item.setListHonin1_8(entity.get本人更正前().get本人老齢年金開始年月日());
            item.setListHonin1_9(entity.get本人更正前().get本人老齢年金終了年月日());
            item.setListHonin1_10(entity.get本人更正前().get本人限界層該当開始年月日());
            item.setListHonin1_11(entity.get本人更正前().get本人限界層該当終了年月日());
            item.setListHonin2_1(entity.get本人更正前().get本人識別コード());
            item.setListHonin2_2(entity.get本人更正前().get本人氏名());
            item.setListHonin2_3(entity.get本人更正前().get本人性別());
            item.setListHonin2_4(entity.get本人更正前().get本人生年月日());
            item.setListHonin2_5(entity.get本人更正前().get本人続柄());
        }
    }

    /**
     * set本人（更正後）
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setHonninKoseiAto(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get本人更正後() != null) {
            item.setListHonin1_1(entity.get本人更正後().get本人資格取得日());
            item.setListHonin1_2(entity.get本人更正後().get本人取得事由());
            item.setListHonin1_3(entity.get本人更正後().get本人資格喪失日());
            item.setListHonin1_4(entity.get本人更正後().get本人喪失事由());
            item.setListHonin1_5(entity.get本人更正後().get本人住所地特例());
            item.setListHonin1_6(entity.get本人更正後().get本人生活保護開始年月日());
            item.setListHonin1_7(entity.get本人更正後().get本人生活保護終了年月日());
            item.setListHonin1_8(entity.get本人更正後().get本人老齢年金開始年月日());
            item.setListHonin1_9(entity.get本人更正後().get本人老齢年金終了年月日());
            item.setListHonin1_10(entity.get本人更正後().get本人限界層該当開始年月日());
            item.setListHonin1_11(entity.get本人更正後().get本人限界層該当終了年月日());
            item.setListHonin2_1(entity.get本人更正後().get本人識別コード());
            item.setListHonin2_2(entity.get本人更正後().get本人氏名());
            item.setListHonin2_3(entity.get本人更正後().get本人性別());
            item.setListHonin2_4(entity.get本人更正後().get本人生年月日());
            item.setListHonin2_5(entity.get本人更正後().get本人続柄());
        }
    }

    /**
     * set特徴月
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setTokubetsuChoshuTsuki(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get特徴月() != null) {
            item.setListTokuchoTsuki_1(entity.get特徴月().get特徴月１());
            item.setListTokuchoTsuki_10(entity.get特徴月().get特徴月１０());
            item.setListTokuchoTsuki_11(entity.get特徴月().get特徴月１１());
            item.setListTokuchoTsuki_12(entity.get特徴月().get特徴月１２());
            item.setListTokuchoTsuki_13(entity.get特徴月().get特徴月１３());
            item.setListTokuchoTsuki_14(entity.get特徴月().get特徴月１４());
            item.setListTokuchoTsuki_2(entity.get特徴月().get特徴月２());
            item.setListTokuchoTsuki_3(entity.get特徴月().get特徴月３());
            item.setListTokuchoTsuki_4(entity.get特徴月().get特徴月４());
            item.setListTokuchoTsuki_5(entity.get特徴月().get特徴月５());
            item.setListTokuchoTsuki_6(entity.get特徴月().get特徴月６());
            item.setListTokuchoTsuki_7(entity.get特徴月().get特徴月７());
            item.setListTokuchoTsuki_8(entity.get特徴月().get特徴月８());
            item.setListTokuchoTsuki_9(entity.get特徴月().get特徴月９());
        }
    }

    /**
     * set特徴期
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setTokubetsuChoshuKi(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get特徴期() != null) {
            item.setListTokuchoKi_1(entity.get特徴期().get特徴期１());
            item.setListTokuchoKi_10(entity.get特徴期().get特徴期１０());
            item.setListTokuchoKi_11(entity.get特徴期().get特徴期１１());
            item.setListTokuchoKi_12(entity.get特徴期().get特徴期１２());
            item.setListTokuchoKi_13(entity.get特徴期().get特徴期１３());
            item.setListTokuchoKi_14(entity.get特徴期().get特徴期１４());
            item.setListTokuchoKi_2(entity.get特徴期().get特徴期２());
            item.setListTokuchoKi_3(entity.get特徴期().get特徴期３());
            item.setListTokuchoKi_4(entity.get特徴期().get特徴期４());
            item.setListTokuchoKi_5(entity.get特徴期().get特徴期５());
            item.setListTokuchoKi_6(entity.get特徴期().get特徴期６());
            item.setListTokuchoKi_7(entity.get特徴期().get特徴期７());
            item.setListTokuchoKi_8(entity.get特徴期().get特徴期８());
            item.setListTokuchoKi_9(entity.get特徴期().get特徴期９());
        }
    }

    /**
     * set普徴期
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setFutsuChoshuKi(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get普徴期() != null) {
            item.setListFuchoKi_1(entity.get普徴期().get普徴期１());
            item.setListFuchoKi_2(entity.get普徴期().get普徴期２());
            item.setListFuchoKi_3(entity.get普徴期().get普徴期３());
            item.setListFuchoKi_4(entity.get普徴期().get普徴期４());
            item.setListFuchoKi_5(entity.get普徴期().get普徴期５());
            item.setListFuchoKi_6(entity.get普徴期().get普徴期６());
            item.setListFuchoKi_7(entity.get普徴期().get普徴期７());
            item.setListFuchoKi_8(entity.get普徴期().get普徴期８());
            item.setListFuchoKi_9(entity.get普徴期().get普徴期９());
            item.setListFuchoKi_10(entity.get普徴期().get普徴期１０());
            item.setListFuchoKi_11(entity.get普徴期().get普徴期１１());
            item.setListFuchoKi_12(entity.get普徴期().get普徴期１２());
            item.setListFuchoKi_13(entity.get普徴期().get普徴期１３());
            item.setListFuchoKi_14(entity.get普徴期().get普徴期１４());
        }
    }

    /**
     * set普徴月
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setFutsuChoshuTsuki(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get普徴月() != null) {
            item.setListFuchoTsuki_1(entity.get普徴月().get普徴月１());
            item.setListFuchoTsuki_2(entity.get普徴月().get普徴月２());
            item.setListFuchoTsuki_3(entity.get普徴月().get普徴月３());
            item.setListFuchoTsuki_4(entity.get普徴月().get普徴月４());
            item.setListFuchoTsuki_5(entity.get普徴月().get普徴月５());
            item.setListFuchoTsuki_6(entity.get普徴月().get普徴月６());
            item.setListFuchoTsuki_7(entity.get普徴月().get普徴月７());
            item.setListFuchoTsuki_8(entity.get普徴月().get普徴月８());
            item.setListFuchoTsuki_9(entity.get普徴月().get普徴月９());
            item.setListFuchoTsuki_10(entity.get普徴月().get普徴月１０());
            item.setListFuchoTsuki_11(entity.get普徴月().get普徴月１１());
            item.setListFuchoTsuki_12(entity.get普徴月().get普徴月１２());
            item.setListFuchoTsuki_13(entity.get普徴月().get普徴月１３());
            item.setListFuchoTsuki_14(entity.get普徴月().get普徴月１４());
        }
    }

    /**
     * set普徴月
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setFutsuChoshuZuiji(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null && entity.get普徴随時() != null) {
            item.setListFuchoZuiji_1(entity.get普徴随時().get普徴随時１());
            item.setListFuchoZuiji_2(entity.get普徴随時().get普徴随時２());
            item.setListFuchoZuiji_3(entity.get普徴随時().get普徴随時３());
            item.setListFuchoZuiji_4(entity.get普徴随時().get普徴随時４());
            item.setListFuchoZuiji_5(entity.get普徴随時().get普徴随時５());
            item.setListFuchoZuiji_6(entity.get普徴随時().get普徴随時６());
            item.setListFuchoZuiji_7(entity.get普徴随時().get普徴随時７());
            item.setListFuchoZuiji_8(entity.get普徴随時().get普徴随時８());
            item.setListFuchoZuiji_9(entity.get普徴随時().get普徴随時９());
            item.setListFuchoZuiji_10(entity.get普徴随時().get普徴随時１０());
            item.setListFuchoZuiji_11(entity.get普徴随時().get普徴随時１１());
            item.setListFuchoZuiji_12(entity.get普徴随時().get普徴随時１２());
            item.setListFuchoZuiji_13(entity.get普徴随時().get普徴随時１３());
            item.setListFuchoZuiji_14(entity.get普徴随時().get普徴随時１４());
        }
    }

    /**
     * setItemBase
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     */
    private void setItemBase(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity) {
        if (entity != null) {
            item.setKozaMeiginin(entity.get口座名義人());
            item.setBankName(entity.get金融機関名());
            item.setBankNo(entity.get金融機関番号());
            item.setChoteiJiyu1(entity.get調定事由1());
            item.setChoteiJiyu2(entity.get調定事由2());
            item.setChoteiJiyu3(entity.get調定事由3());
            item.setChoteiJiyu4(entity.get調定事由4());
            item.setChoteiNendo(entity.get調定年度());
            item.setDainoninJusho(entity.get代納人住所());
            item.setDainoninName(entity.get代納人名称());
            item.setDainoninNameKana(entity.get代納人名称カナ());
            item.setDainoninRenrakuSaki1(entity.get代納人連絡先１());
            item.setDainoninRenrakuSaki2(entity.get代納人連絡先２());
            item.setDainoninyubinNo(entity.get代納人郵便NO());
            item.setFukaNendo(entity.get賦課年度());
            item.setHenkoJiyu1(entity.get変更事由1());
            item.setHenkoJiyu2(entity.get変更事由2());
            item.setHenkoJiyu3(entity.get変更事由3());
            item.setHenkoJiyu4(entity.get変更事由4());
            item.setHihokenshaNo(entity.get被保険者番号().value());
            item.setHokenshaName(entity.get保険者名称());
            item.setHokenshaNo(entity.get保険者番号().value());
            item.setHoninBirthYMD(entity.get本人生年月日());
            item.setHoninJusho(entity.get本人住所());
            item.setHoninName(entity.get本人名称());
            item.setHoninNameKana(entity.get本人名称カナ());
            item.setHoninRenrakuSaki1(entity.get本人連絡先１());
            item.setHoninRenrakuSaki2(entity.get本人連絡先２());
            item.setHoninSeibetsu(entity.get本人性別());
            item.setHoninShotokuDankaiHenko(entity.get本人所得段階変更());
            item.setHoninTokuchoGimusha(entity.get本人特徴義務者());
            item.setHoninTokuchoTaishoNenkin(entity.get本人特徴対象年金());
            item.setHoninyubinNo(entity.get本人郵便番号());
            item.setHyojicode1(entity.get表示コード１());
            item.setHyojicode2(entity.get表示コード２());
            item.setHyojicode3(entity.get表示コード３());
            item.setHyojicodeName1(entity.get表示コード名称１());
            item.setHyojicodeName2(entity.get表示コード名称２());
            item.setHyojicodeName3(entity.get表示コード名称３());
            item.setJukyuJoho(entity.get受給情報());
            item.setKazeiHikazei(entity.get課税区分());
            item.setKozaNo(entity.get口座NO());
            item.setKozaShurui(entity.get口座種類());
        }
    }

    /**
     * set世帯員情報リストPart1
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     * @param index int
     */
    private void set世帯員情報リストPart1(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity,
            int index) {
        if (entity.get世帯員情報リスト().size() > index) {
            item.setListSetaiin_1(entity.get世帯員情報リスト().get(index).get世帯員識別コード());
            item.setListSetaiin_2(entity.get世帯員情報リスト().get(index).get世帯員氏名());
            item.setListSetaiin_3(entity.get世帯員情報リスト().get(index).get世帯員性別());
            item.setListSetaiin_4(entity.get世帯員情報リスト().get(index).get世帯員生年月日());
            item.setListSetaiin_5(entity.get世帯員情報リスト().get(index).get世帯員続柄());
            item.setListSetaiin_6(entity.get世帯員情報リスト().get(index).get世帯員合計取得金額());
            item.setListSetaiin_7(RString.isNullOrEmpty(entity.get世帯員情報リスト().get(index).get世帯員課税区分())
                    ? RString.EMPTY : KazeiKubun.toValue(entity.get世帯員情報リスト().get(index).get世帯員課税区分()).get名称());
        }
    }

    /**
     * set世帯員情報リストPart2
     *
     * @param item FukaDaichoItem
     * @param entity EditedHonSanteiFukaDaichoJoho
     * @param index int
     */
    private void set世帯員情報リストPart2(FukaDaichoItem item,
            EditedHonSanteiFukaDaichoJoho entity,
            int index) {
        if (entity.get世帯員情報リスト().size() > index) {
            item.setListSetaiin_8(entity.get世帯員情報リスト().get(index).get世帯員識別コード());
            item.setListSetaiin_9(entity.get世帯員情報リスト().get(index).get世帯員氏名());
            item.setListSetaiin_10(entity.get世帯員情報リスト().get(index).get世帯員性別());
            item.setListSetaiin_11(entity.get世帯員情報リスト().get(index).get世帯員生年月日());
            item.setListSetaiin_12(entity.get世帯員情報リスト().get(index).get世帯員続柄());
            item.setListSetaiin_13(entity.get世帯員情報リスト().get(index).get世帯員合計取得金額());
            item.setListSetaiin_14(RString.isNullOrEmpty(entity.get世帯員情報リスト().get(index).get世帯員課税区分())
                    ? RString.EMPTY : KazeiKubun.toValue(entity.get世帯員情報リスト().get(index).get世帯員課税区分()).get名称());
        }
    }

}
