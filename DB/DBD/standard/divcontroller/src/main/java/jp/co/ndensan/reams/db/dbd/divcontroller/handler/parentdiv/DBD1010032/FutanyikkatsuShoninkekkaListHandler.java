/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010032;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.FutanyikkatsuShoninList;
import jp.co.ndensan.reams.db.dbd.business.core.futangendogakunintei.FutanGendogakuNinteiBatchResult;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032.FutanyikkatsuShoninkekkaListDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010032.dgNinteiIchiran_Row;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakunintei.FutangendogakuyikkatsuShoninEntity;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.IkkatsuShoninKekkaIchiranService;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 一括承認結果一覧ののHandlerです
 *
 * @reamsid_L DBD-3710-030 xuejm
 */
public class FutanyikkatsuShoninkekkaListHandler {

    private final FutanyikkatsuShoninkekkaListDiv div;
    private static final RString 承認済みフラグtrue = new RString("TRUE");
    private static final RString 承認を確定する = new RString("Element2");
    private static final RString 修正を保存する = new RString("btnExecute");
    private static final RString 全件 = new RString("0");

    /**
     * 負担限度額認定申請承認（一括）コンストラクタです。
     *
     * @param div FutanyikkatsuShoninkekkaListDiv
     */
    public FutanyikkatsuShoninkekkaListHandler(FutanyikkatsuShoninkekkaListDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     */
    public void onLoad() {
        List<YMDHMS> 一括処理日時list = IkkatsuShoninKekkaIchiranService.createInstance().load一括処理日時();
        div.getHyojiTaisho().getDdlBatchShoriNichiji().setDataSource(onLoad_ddlServiceYMDHMS(一括処理日時list));
        if (div.getHyojiTaisho().getDdlBatchShoriNichiji().getDataSource() != null
                && !div.getHyojiTaisho().getDdlBatchShoriNichiji().getDataSource().isEmpty()) {
            div.getHyojiTaisho().getDdlBatchShoriNichiji().setSelectedKey(div.getHyojiTaisho().getDdlBatchShoriNichiji()
                    .getDataSource().get(0).getValue());
        }
        RString 一括認定バッチ処理日時 = div.getHyojiTaisho().getDdlBatchShoriNichiji().getSelectedKey();
        FutangendogakuyikkatsuShoninEntity 負担限度額一括認定情報 = IkkatsuShoninKekkaIchiranService.createInstance()
                .load負担限度額一括認定情報(一括認定バッチ処理日時);
        if (負担限度額一括認定情報 != null) {
            if (承認済みフラグtrue.equals(new RString(負担限度額一括認定情報.get承認済みフラグ().toString()))) {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(承認を確定する, true);
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(修正を保存する, false);
            } else {
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(承認を確定する, false);
                CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(修正を保存する, true);
            }
        }
    }

    /**
     * 介護保険負担限度額認定の情報を更新する。
     *
     * @param 画面更新用情報 List<FutanGendogakuNinteiBatchResult>
     */
    public void ＤＢ処理更新(List<FutanGendogakuNinteiBatchResult> 画面更新用情報) {
        IkkatsuShoninKekkaIchiranService ikkatsuservice = IkkatsuShoninKekkaIchiranService.createInstance();
        RString 一括認定バッチ処理日時 = div.getHyojiTaisho().getDdlBatchShoriNichiji().getSelectedKey();
        ikkatsuservice.ＤＢ処理_updata介護保険負担限度額認定(画面更新用情報);
        ikkatsuservice.ＤＢ処理_減免減額申請(画面更新用情報);
        ＤＢ処理_負担限度額一括認定(一括認定バッチ処理日時);
    }

    /**
     * ＤＢ負担限度額一括認定の情報を更新する。
     *
     * @param 一括認定バッチ処理日時
     */
    public void ＤＢ処理_負担限度額一括認定(RString 一括認定バッチ処理日時) {
        IkkatsuShoninKekkaIchiranService ikkatsuservice = IkkatsuShoninKekkaIchiranService.createInstance();
        FutanyikkatsuShoninList 更新futanlist = ikkatsuservice.get負担限度額一括認定情報(一括認定バッチ処理日時);
        if (更新futanlist != null) {
            更新futanlist = 更新futanlist.createBuilderForEdit()
                    .set承認済みフラグ(true)
                    .build()
                    .modifiedModel();
            ikkatsuservice.saveDbT4035dac(更新futanlist);
        }
    }

    /**
     * 介護保険負担限度額認定を更新する。
     *
     * @param 画面更新用情報 List<FutanGendogakuNinteiBatchResult>
     */
    public void ＤＢ更新(List<FutanGendogakuNinteiBatchResult> 画面更新用情報) {
        IkkatsuShoninKekkaIchiranService ikkatsuservice = IkkatsuShoninKekkaIchiranService.createInstance();
        ikkatsuservice.update介護保険負担限度額認定(画面更新用情報);
        ikkatsuservice.get減免減額申請更新(画面更新用情報);
    }

    /**
     * 一括処理日時リストを設定する。
     *
     * @param 一括処理日時list List<YMDHMS>
     * @return List<KeyValueDataSource>
     */
    private List<KeyValueDataSource> onLoad_ddlServiceYMDHMS(List<YMDHMS> 一括処理日時list) {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (YMDHMS ymdhms : 一括処理日時list) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            RTime システムtime = RTime.now();
            RString 年月日 = ymdhms.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();
            RString 時分秒 = システムtime.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            dataSource.setValue(年月日.concat("　").concat(時分秒));
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    /**
     * 申請一覧情報データ処理です。
     *
     * @param 負担限度額認定バッチ結果 負担限度額認定バッチ結果
     * @return 最初申請一覧情報
     */
    public ArrayList<dgNinteiIchiran_Row> setDgShinseiIchiran_Row(List<FutanGendogakuNinteiBatchResult> 負担限度額認定バッチ結果) {
        ArrayList<dgNinteiIchiran_Row> 一括承認結果一覧 = new ArrayList<>();
        if (負担限度額認定バッチ結果 != null) {
            for (FutanGendogakuNinteiBatchResult futangenresult : 負担限度額認定バッチ結果) {
                dgNinteiIchiran_Row futangendogakunintei = new dgNinteiIchiran_Row();
                if (futangenresult != null) {
                    if (futangenresult.get介護保険負担限度額認定の情報().getState().equals(EntityDataState.Modified)) {
                        futangendogakunintei.setJotai(new RString("修正"));
                    }
                    futangendogakunintei.setHihoNo(futangenresult.get介護保険負担限度額認定の情報().get被保険者番号().value());
                    futangendogakunintei.setShikibetsuCode(futangenresult.get個人().get識別コード().value());
                    futangendogakunintei.getTxtSeinengappiYMD().setValue(futangenresult.get個人().get生年月日().toFlexibleDate());
                    futangendogakunintei.setNenrei(futangenresult.get個人().get年齢算出().get年齢());
                    futangendogakunintei.setKetteiKubun(futangenresult.get介護保険負担限度額認定の情報().get決定区分());
                    futangendogakunintei.getTxtKetteiYMD().setValue(futangenresult.get介護保険負担限度額認定の情報().get決定年月日());
                    futangendogakunintei.getTxtTekiyoYMD().setValue(futangenresult.get介護保険負担限度額認定の情報().get適用開始年月日());
                    futangendogakunintei.getTxtYukoKigenYMD().setValue(futangenresult.get介護保険負担限度額認定の情報().get適用終了年月日());
                    futangendogakunintei.setFutanDankai(futangenresult.get介護保険負担限度額認定の情報().get利用者負担段階());
                }
                if (div.getRadHyojiNaiyo().getSelectedKey().equals(全件)) {
                    一括承認結果一覧.add(futangendogakunintei);

                } else if (futangendogakunintei.getKetteiKubun().isEmpty() && futangendogakunintei.getKetteiKubun() == null) {
                    一括承認結果一覧.add(futangendogakunintei);
                }
            }
        }
        return 一括承認結果一覧;
    }

    /**
     * 確認ダイアログDbInformationMessageを表示する
     */
    public enum DbInformationMessage implements IValidationMessage {

        保存処理完了(DbzInformationMessages.保存処理完了, "修正内容");

        private final Message message;

        private DbInformationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
