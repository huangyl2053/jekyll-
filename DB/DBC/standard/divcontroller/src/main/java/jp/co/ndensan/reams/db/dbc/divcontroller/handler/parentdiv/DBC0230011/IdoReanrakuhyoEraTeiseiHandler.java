/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0230011;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.jukyusyaidoujohorirek.JukyusyaIdouJohoRirekEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0230011.IdoReanrakuhyoEraTeiseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0230011.dgIdoReanrakuhyoEraTeisei_Row;
import jp.co.ndensan.reams.db.dbc.service.core.jukyushaidorenrakuhyoerrorteisei.JukyushaIdoRenrakuhyoErrorTeisei;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0885SharedFileEntryEntity;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * IdoReanrakuhyoEraTeisei_1_受給者異動連絡票エラー訂正のHandlerクラスです。
 *
 * @reamsid_L DBC-2720-010 liuxiaoyu
 */
public class IdoReanrakuhyoEraTeiseiHandler {

    private static final RString 履歴訂正リストファイル = new RString("JukyusyaIdouJohoRirekilist.csv");
    private static final RString 引数 = new RString("履歴訂正データなし");
    private static final RString DB = new RString("DB");
    private static final RString コロン = new RString(":");
    private static final RString 中黒 = new RString(".");
    private static final RString ハイフン = new RString("-");
    private final IdoReanrakuhyoEraTeiseiDiv div;
    private final JukyushaIdoRenrakuhyoErrorTeisei service;

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public IdoReanrakuhyoEraTeiseiHandler(IdoReanrakuhyoEraTeiseiDiv div) {
        this.div = div;
        this.service = InstanceProvider.create(JukyushaIdoRenrakuhyoErrorTeisei.class);
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     *
     * @return IdoReanrakuhyoEraTeiseiHandler
     */
    public static IdoReanrakuhyoEraTeiseiHandler of(IdoReanrakuhyoEraTeiseiDiv div) {
        return new IdoReanrakuhyoEraTeiseiHandler(div);
    }

    /**
     * 画面初期化のチェックし,初期化メソッドです
     */
    public void onLoad() {

        File file;
        List<JukyusyaIdouJohoRirekEntity> list = new ArrayList<>();
        List<JukyusyaIdouJohoRirekEntity> tempList;
        List<UzT0885SharedFileEntryEntity> entityList = SharedFile.searchSharedFile(履歴訂正リストファイル);
        if (entityList != null && !entityList.isEmpty()) {
            for (UzT0885SharedFileEntryEntity entity : entityList) {
                file = new File(SharedFile.getBasePath().concat(File.separator)
                        .concat(DB.toString()).concat(File.separator)
                        .concat(entity.getSharedFileName().toString()).concat(File.separator)
                        .concat((entity.getSharedFileId().toString().replace(コロン.toString(), 中黒.toString())
                                .replace(ハイフン.toString(), 中黒.toString()))).concat(File.separator)
                        .concat(履歴訂正リストファイル.toString()));
                if (file.exists()) {
                    tempList = service.getRirekiTeiseiJoho(file);
                    list.addAll(tempList);
                }
            }
        } else {
            throw new ApplicationException(
                    UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(引数.toString()));
        }
        if (list.isEmpty()) {
            throw new ApplicationException(
                    UrErrorMessages.対象データなし_追加メッセージあり.getMessage().replace(引数.toString()));
        }
        dgIdoReanrakuhyoEraTeisei_Row idoRow;
        List<dgIdoReanrakuhyoEraTeisei_Row> rowList = new ArrayList<>();
        for (JukyusyaIdouJohoRirekEntity entity : list) {
            idoRow = new dgIdoReanrakuhyoEraTeisei_Row();
            idoRow.getTxtIdobi().setValue(new RDate(entity.get異動日().toString()));
            idoRow.setTxtHihoBango(entity.get被保番号().value());
            idoRow.setTxtKanaShimei(entity.getかな氏名());
            idoRow.setTxtKomoku(entity.get項目());
            rowList.add(idoRow);
        }
        div.getDgIdoReanrakuhyoEraTeisei().setDataSource(rowList);
    }
}
