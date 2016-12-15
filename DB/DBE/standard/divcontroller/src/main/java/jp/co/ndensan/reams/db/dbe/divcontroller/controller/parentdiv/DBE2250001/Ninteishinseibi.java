/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE2250001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.DBE2250001StateName;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001.NinteishinseibiHandler;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001.NinteishinseibiValidatisonHandler;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakainenkansukejuruhyo.NiTeiCyoSaiChiRanManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokkiBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItemBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlagBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikoBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.MessageDialogSelectedResult;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 認定調査データ取込（モバイル）クラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class Ninteishinseibi {

    private final NiTeiCyoSaiChiRanManager manager;
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * コンストラクタです。
     *
     */
    public Ninteishinseibi() {
        this.manager = NiTeiCyoSaiChiRanManager.createInstance();
    }

    /**
     * 認定調査データ取込（モバイル）の初期処理を表示します。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onLoad(NinteishinseibiDiv div) {
        getHandler(div).initializtion();
        return ResponseData.of(div).setState(DBE2250001StateName.初期表示);
    }

    /**
     * 取込むボタン。
     *
     * @param div NinteishinseibiDiv
     * @param files FileData
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onClick_btnUpload(NinteishinseibiDiv div, FileData[] files) {

        RString ファイルパス = RString.EMPTY;
        for (FileData file : files) {
            ファイルパス = file.getFilePath();
            div.setファイルPath(ファイルパス);
            break;
        }

        List<ChosaKekkaNyuryokuCsvEntity> csvEntityList = データ取込(ファイルパス);
        ValidationMessageControlPairs vallidation = getValidatisonHandler(div).取込対象データチェック(csvEntityList.isEmpty());
        if (vallidation.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(vallidation).respond();
        }

        List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getDataSource();
        for (ChosaKekkaNyuryokuCsvEntity entity : csvEntityList) {
            dgNinteiChosaData_Row row = new dgNinteiChosaData_Row();
            getHandler(div).取込むの編集(row, entity);
            rowList.add(row);
        }
        div.getTxtNinzu().setValue(new RString(rowList.size()));
        div.getDgNinteiChosaData().setDataSource(rowList);
        return ResponseData.of(div).respond();
    }

    /**
     * アップロードが完了した後に実行されます。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> onAfterUploaded_btnImport(NinteishinseibiDiv div) {
        return ResponseData.of(div).setState(DBE2250001StateName.検索結果表示);
    }

    /**
     * 保存ボタンの処理。
     *
     * @param div NinteishinseibiDiv
     * @return ResponseData
     */
    public ResponseData<NinteishinseibiDiv> btn_save(NinteishinseibiDiv div) {

        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.保存の確認.getMessage().getCode(),
                    UrQuestionMessages.保存の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        if (new RString(UrQuestionMessages.保存の確認.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())
                && ResponseHolder.getButtonType() == MessageDialogSelectedResult.Yes) {

            List<dgNinteiChosaData_Row> rowList = div.getDgNinteiChosaData().getDataSource();
            for (dgNinteiChosaData_Row row : rowList) {

                if (!RString.isNullOrEmpty(row.getJyoutai())) {
                    NinteichosahyoGaikyoChosa gaikyoChosa = 認定調査票_概況調査の登録処理(row, div);
                    GaikyoTokki gaikyoTokki = 認定調査票_概況特記の登録処理(row, div);
                    NinteichosahyoTokkijiko yoTokkijiko = 認定調査票_特記情報の登録処理(row, div);
                    NinteichosahyoKihonChosa kihonChosa = 認定調査票_基本調査の登録処理(row, div);
                    NinteichosahyoChosaItem chosaItem = 認定調査票_基本調査調査項目の登録処理(row, div);
                    NinteichosahyoServiceJokyo serviceJokyo = 認定調査票_概況調査サービスの状況の登録処理(row, div);
                    NinteichosahyoServiceJokyoFlag serviceJokyoFlag = 認定調査票_概況調査サービスの状況フラグの登録処理(row, div);
                    NinteichosahyoKinyuItem kinyuItem = 認定調査票_概況調査記入項目の登録処理(row, div);
                    NinteichosahyoShisetsuRiyo shisetsuRiyo = 認定調査票_概況調査施設利用の登録処理(row, div);

                    manager.認定調査一覧更新処理(
                            new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                            Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                            TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード(),
                            row.getNinteichosaTokkijikoNo(),
                            TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード(),
                            new Code(GenponMaskKubun.valueOf(row.getGenponMaskKubun().toString()).getコード()),
                            yoTokkijiko,
                            gaikyoChosa,
                            gaikyoTokki,
                            kihonChosa,
                            Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                            chosaItem,
                            serviceJokyo,
                            serviceJokyoFlag,
                            kinyuItem,
                            shisetsuRiyo,
                            Integer.valueOf(row.getRemban().toString()),
                            Integer.valueOf(row.getNinteichosaTokkijikoRemban().toString()),
                            Integer.valueOf(row.getServiceJokyoRemban().toString()),
                            Integer.valueOf(row.getServiceJokyoFlagRemban().toString()),
                            Integer.valueOf(row.getServiceJokyoKinyuRemban().toString()),
                            Integer.valueOf(row.getShisetsuRiyoFlagRemban().toString()));
                }
            }
            div.getCcdKanryoMessage().setSuccessMessage(
                    new RString(UrInformationMessages.保存終了.getMessage().evaluate()), RString.EMPTY, RString.EMPTY);
            return ResponseData.of(div).setState(DBE2250001StateName.完了);
        }
        return ResponseData.of(div).respond();
    }

    private NinteichosahyoGaikyoChosa 認定調査票_概況調査の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoGaikyoChosa ninteichosahyoGaikyoChosa = new NinteichosahyoGaikyoChosa(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());

        NinteichosahyoGaikyoChosaBuilder gaikyoChosaBuilder = getHandler(div).認定調査票概況調査の編集(row, ninteichosahyoGaikyoChosa);
        return gaikyoChosaBuilder.build();
    }

    private NinteichosahyoTokkijiko 認定調査票_特記情報の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoTokkijiko ninteichosahyoTokkijiko = new NinteichosahyoTokkijiko(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                row.getNinteichosaTokkijikoNo(),
                Integer.valueOf(row.getNinteichosaTokkijikoRemban().toString()),
                TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード(),
                new Code(GenponMaskKubun.valueOf(row.getGenponMaskKubun().toString()).getコード()));

        NinteichosahyoTokkijikoBuilder ninteichosahyoTokkijikoBuilder = getHandler(div).認定調査票特記情報の編集(row, ninteichosahyoTokkijiko);
        return ninteichosahyoTokkijikoBuilder.build();
    }

    private GaikyoTokki 認定調査票_概況特記の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        GaikyoTokki gaikyoTokki = new GaikyoTokki(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                TokkijikoTextImageKubun.valueOf(row.getGaikyoTokkiTextImageKubun().toString()).getコード());

        GaikyoTokkiBuilder gaikyoTokkiBuilder = getHandler(div).認定調査票概況特記の編集(row, gaikyoTokki);
        return gaikyoTokkiBuilder.build();
    }

    private NinteichosahyoKihonChosa 認定調査票_基本調査の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoKihonChosa ninteichosahyoKihonChosa = new NinteichosahyoKihonChosa(new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()));

        NinteichosahyoKihonChosaBuilder kihonChosaBuilder = getHandler(div).認定調査票基本調査の編集(row, ninteichosahyoKihonChosa);
        return kihonChosaBuilder.build();
    }

    private NinteichosahyoChosaItem 認定調査票_基本調査調査項目の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoChosaItem ninteichosahyoChosaItem = new NinteichosahyoChosaItem(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getRemban().toString()));

        NinteichosahyoChosaItemBuilder ninteichosahyoChosaItemBuilder = getHandler(div).
                認定調査票基本調査調査項目の編集(row, ninteichosahyoChosaItem);
        return ninteichosahyoChosaItemBuilder.build();
    }

    private NinteichosahyoServiceJokyo 認定調査票_概況調査サービスの状況の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoServiceJokyo ninteichosahyoServiceJokyo = new NinteichosahyoServiceJokyo(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getServiceJokyoRemban().toString()));

        NinteichosahyoServiceJokyoBuilder serviceJokyoBuilder = getHandler(div).認定調査票概況調査サービスの状況の編集(row, ninteichosahyoServiceJokyo);
        return serviceJokyoBuilder.build();
    }

    private NinteichosahyoServiceJokyoFlag 認定調査票_概況調査サービスの状況フラグの登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoServiceJokyoFlag ninteichosahyoServiceJokyoFlag = new NinteichosahyoServiceJokyoFlag(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getServiceJokyoFlagRemban().toString()));

        NinteichosahyoServiceJokyoFlagBuilder serviceJokyoFlagBuilder = getHandler(div).
                認定調査票概況調査サービスの状況フラグの編集(row, ninteichosahyoServiceJokyoFlag);
        return serviceJokyoFlagBuilder.build();
    }

    private NinteichosahyoKinyuItem 認定調査票_概況調査記入項目の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoKinyuItem ninteichosahyoKinyuItem = new NinteichosahyoKinyuItem(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getServiceJokyoKinyuRemban().toString()));

        NinteichosahyoKinyuItemBuilder ninteichosahyoKinyuItemBuilder = getHandler(div).
                認定調査票概況調査記入項目の編集(row, ninteichosahyoKinyuItem);
        return ninteichosahyoKinyuItemBuilder.build();
    }

    private NinteichosahyoShisetsuRiyo 認定調査票_概況調査施設利用の登録処理(dgNinteiChosaData_Row row, NinteishinseibiDiv div) {

        NinteichosahyoShisetsuRiyo ninteichosahyoShisetsuRiyo = new NinteichosahyoShisetsuRiyo(
                new ShinseishoKanriNo(row.getShinseishoKanriNo()),
                Integer.valueOf(row.getNinteichosaIraiRirekiNo().toString()),
                Integer.valueOf(row.getShisetsuRiyoFlagRemban().toString()));

        NinteichosahyoShisetsuRiyoBuilder shisetsuRiyoBuilder = getHandler(div).
                認定調査票概況調査施設利用の編集(row, ninteichosahyoShisetsuRiyo);
        return shisetsuRiyoBuilder.build();
    }

    private List<ChosaKekkaNyuryokuCsvEntity> データ取込(RString ファイルPath) {
        CsvReader csvReader = new CsvReader.InstanceBuilder(ファイルPath, ChosaKekkaNyuryokuCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile(csvReader);
    }

    private List<ChosaKekkaNyuryokuCsvEntity> readCsvFile(CsvReader csvReader) {
        List<ChosaKekkaNyuryokuCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ChosaKekkaNyuryokuCsvEntity entity = (ChosaKekkaNyuryokuCsvEntity) csvReader.readLine();
            if (entity != null) {
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return csvEntityList;
    }

    private NinteishinseibiHandler getHandler(NinteishinseibiDiv div) {
        return new NinteishinseibiHandler(div);
    }

    private NinteishinseibiValidatisonHandler getValidatisonHandler(NinteishinseibiDiv div) {
        return new NinteishinseibiValidatisonHandler(div);
    }
}
