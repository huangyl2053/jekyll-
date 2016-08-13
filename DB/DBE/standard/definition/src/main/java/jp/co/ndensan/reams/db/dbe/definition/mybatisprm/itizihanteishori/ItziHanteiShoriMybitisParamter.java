/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.itizihanteishori;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * バッチ設計_DBE309000_一次判定処理のバッチ処理クラスです。
 *
 * @reamsid_L DBE-1470-020 wanghui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class ItziHanteiShoriMybitisParamter implements IMyBatisParameter {

    private final List<ShinseishoKanriNo> shinseishoKanriNoList;
    private final RString battishuturyokukubun;
    private final RString イメージ区分;
    private final RString 取下;
    private final RString 延期;

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList List<RString>
     * @param battishuturyokukubun RString
     * @param イメージ区分 RString
     */
    private ItziHanteiShoriMybitisParamter(
            List<ShinseishoKanriNo> shinseishoKanriNoList,
            RString battishuturyokukubun,
            RString イメージ区分,
            RString 取下,
            RString 延期) {
        this.shinseishoKanriNoList = shinseishoKanriNoList;
        this.battishuturyokukubun = battishuturyokukubun;
        this.イメージ区分 = イメージ区分;
        this.取下 = 取下;
        this.延期 = 延期;
    }

    /**
     * コンストラクタです。
     *
     * @param shinseishoKanriNoList List<RString>
     * @param battishuturyokukubun RString
     * @param イメージ区分 RString
     * @param 取下 RString
     * @param 延期 RString
     * @return ItziHanteiShoriMybitisParamter
     */
    public static ItziHanteiShoriMybitisParamter createParam(
            List<ShinseishoKanriNo> shinseishoKanriNoList,
            RString battishuturyokukubun,
            RString イメージ区分,
            RString 取下,
            RString 延期
    ) {
        return new ItziHanteiShoriMybitisParamter(shinseishoKanriNoList, battishuturyokukubun,
                イメージ区分, 取下, 延期);
    }
}
