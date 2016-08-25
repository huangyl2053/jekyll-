/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.itizihanteishori;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.itizihanteishori.ItziHanteiShoriProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBE309000_一次判定処理のバッチパラメータクラスです。
 *
 * @reamsid_L DBE-1470-020 wanghui
 */
@Getter
@Setter
public class ItziHanteiShoriBatchParamter extends BatchParameterBase {

    private static final String SHINSEISHOLANRINOLIST = "shinseishoKanriNoList";
    private static final String BATTISHUTURYOKUKUBUN = "battishuturyokukubun";
    private static final String FILEPATH = "filePath";
    @BatchParameter(key = SHINSEISHOLANRINOLIST, name = "申請書管理番号リスト")
    private List<RString> shinseishoKanriNoList;
    @BatchParameter(key = BATTISHUTURYOKUKUBUN, name = "バッチ出力区分")
    private RString battishuturyokukubun;
    @BatchParameter(key = FILEPATH, name = "込ファイルパス")
    private RString filePath;

    /**
     * バッチ設計_DBE309001_一次判定IF作成のMybatisパラメータークラス作成
     *
     * @return ItziHanteiShoriProcessParamter
     */
    public ItziHanteiShoriProcessParamter toProcessParameter() {
        return new ItziHanteiShoriProcessParamter(shinseishoKanriNoList,
                battishuturyokukubun, filePath);
    }
}
