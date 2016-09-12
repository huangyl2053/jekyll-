/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.DBZ0400002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002.ChohyoSeigyoMaintenacePanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0400002.dgCyohyoSeigyo_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 帳票制御メンテナンスのhandlerです。
 *
 * @reamsid_L DBA-1201-030 yaodongsheng
 */
public class ChohyoSeigyoMaintenaceHandler {

    private final ChohyoSeigyoMaintenacePanelDiv div;
    private static final RString バリデーション無し = new RString("0");
    private static final RString バリデーション有り = new RString("1");
    private static final RString BREAK = new RString("<br/>");
    private static final RString SPACE = new RString("　");
    private static final RString BUNGO = new RString("：");

    /**
     * コンストラクタです。
     *
     * @param div ChohyoSeigyoMaintenaceDiv
     */
    public ChohyoSeigyoMaintenaceHandler(ChohyoSeigyoMaintenacePanelDiv div) {
        this.div = div;
    }

    /**
     *
     * 帳票制御メンテナンス初期化の設定します。
     *
     * @param businessList 資格不整合一覧情報
     * @param 帳票名称 帳票名称
     */
    public void load(List<ChohyoSeigyoHanyo> businessList, RString 帳票名称) {
        div.getLblChohyoName().setText(帳票名称);
        List<dgCyohyoSeigyo_Row> rowList = new ArrayList<>();
        for (ChohyoSeigyoHanyo chohyoSeigyoHanyo : businessList) {
            dgCyohyoSeigyo_Row row = new dgCyohyoSeigyo_Row();
            row.setStrKomoku(chohyoSeigyoHanyo.get項目名());
            row.getTxtSetteichi().setValue(chohyoSeigyoHanyo.get設定値());
            row.setStrCodeMasterShubetsu(chohyoSeigyoHanyo.getコードマスタコード種別() == null
                    ? RString.EMPTY : chohyoSeigyoHanyo.getコードマスタコード種別().value());
            row.setStrCodeMasterSubCode(chohyoSeigyoHanyo.getコードマスタサブ業務コード() == null
                    ? RString.EMPTY : chohyoSeigyoHanyo.getコードマスタサブ業務コード().value());
            row.setStrKanriNendo(chohyoSeigyoHanyo.get管理年度().toDateString());
            if (chohyoSeigyoHanyo.getコードマスタサブ業務コード() == null
                    || RString.isNullOrEmpty(chohyoSeigyoHanyo.getコードマスタサブ業務コード().value())) {
                row.setValidationUmu(バリデーション無し);
                row.setStrSetsumei(chohyoSeigyoHanyo.get説明());
            } else {
                row.setValidationUmu(バリデーション有り);
                List<UzT0007CodeEntity> entityList = CodeMaster.getCode(chohyoSeigyoHanyo.getコードマスタサブ業務コード(),
                        chohyoSeigyoHanyo.getコードマスタコード種別());
                RStringBuilder setsuMei = new RStringBuilder();
                setsuMei.append(CodeMaster.getShubetsu(chohyoSeigyoHanyo.getコードマスタサブ業務コード(),
                        chohyoSeigyoHanyo.getコードマスタコード種別()).get種別概要()).append(BREAK);
                for (UzT0007CodeEntity entity : entityList) {
                    setsuMei.append(entity.getコード()).append(BUNGO).append(entity.getコード略称()).append(SPACE);
                }
                row.setStrSetsumei(setsuMei.toRString());
            }
            rowList.add(row);
        }
        div.getDgCyohyoSeigyo().setDataSource(rowList);
    }
}
