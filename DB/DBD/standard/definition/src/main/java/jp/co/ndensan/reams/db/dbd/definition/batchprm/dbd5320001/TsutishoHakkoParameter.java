/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd5320001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5320001.NinteiKekkaTsutishoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5320001.ServiceHenkoTsutishoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5320001.YokaigoHenkoTsutishoProcessParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定結果通知書発行のバッチパラメータクラスです。
 *
 * @reamsid_L DBD-1430-020 lit
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TsutishoHakkoParameter extends BatchParameterBase {

    @BatchParameter(key = "出力対象リスト", name = "出力対象リスト")
    private List<ShutsuryokuTaishoKubun> 出力対象;
    @BatchParameter(key = "発行日", name = "発行日")
    private FlexibleDate 発行日;
    @BatchParameter(key = "単票発行済み", name = "単票発行済み")
    private Boolean 単票発行済み;
    @BatchParameter(key = "認定結果通知書今回開始日付", name = "認定結果通知書今回開始日付")
    private FlexibleDate 認定結果通知書今回開始日付;
    @BatchParameter(key = "認定結果通知書今回開始日時", name = "認定結果通知書今回開始日時")
    private RTime 認定結果通知書今回開始日時;
    @BatchParameter(key = "認定結果通知書今回終了日付", name = "認定結果通知書今回終了日付")
    private FlexibleDate 認定結果通知書今回終了日付;
    @BatchParameter(key = "認定結果通知書今回終了日時", name = "認定結果通知書今回終了日時")
    private RTime 認定結果通知書今回終了日時;
    @BatchParameter(key = "認定結果通知書文書番号", name = "認定結果通知書文書番号")
    private RString 認定結果通知書文書番号;
    @BatchParameter(key = "サービス変更通知書今回開始日付", name = "サービス変更通知書今回開始日付")
    private FlexibleDate サービス変更通知書今回開始日付;
    @BatchParameter(key = "サービス変更通知書今回開始日時", name = "サービス変更通知書今回開始日時")
    private RTime サービス変更通知書今回開始日時;
    @BatchParameter(key = "サービス変更通知書今回終了日付", name = "サービス変更通知書今回終了日付")
    private FlexibleDate サービス変更通知書今回終了日付;
    @BatchParameter(key = "サービス変更通知書今回終了日時", name = "サービス変更通知書今回終了日時")
    private RTime サービス変更通知書今回終了日時;
    @BatchParameter(key = "サービス変更通知書文書番号", name = "サービス変更通知書文書番号")
    private RString サービス変更通知書文書番号;
    @BatchParameter(key = "要介護区分変更通知書今回開始日付", name = "要介護区分変更通知書今回開始日付")
    private FlexibleDate 要介護区分変更通知書今回開始日付;
    @BatchParameter(key = "要介護区分変更通知書今回開始日時", name = "要介護区分変更通知書今回開始日時")
    private RTime 要介護区分変更通知書今回開始日時;
    @BatchParameter(key = "要介護区分変更通知書今回終了日付", name = "要介護区分変更通知書今回終了日付")
    private FlexibleDate 要介護区分変更通知書今回終了日付;
    @BatchParameter(key = "要介護区分変更通知書今回終了日時", name = "要介護区分変更通知書今回終了日時")
    private RTime 要介護区分変更通知書今回終了日時;
    @BatchParameter(key = "要介護区分変更通知書文書番号", name = "要介護区分変更通知書文書番号")
    private RString 要介護区分変更通知書文書番号;
    @BatchParameter(key = "出力順", name = "出力順")
    private RString 出力順;

    /**
     * 認定結果通知書のprocessパラメータを作成。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return NinteiKekkaTsutishoProcessParameter
     */
    public NinteiKekkaTsutishoProcessParameter toNinteiKekkaTsutishoProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new NinteiKekkaTsutishoProcessParameter(発行日, 単票発行済み, 出力順, 認定結果通知書文書番号,
                認定結果通知書今回開始日付, 認定結果通知書今回終了日付,
                認定結果通知書今回開始日時, 認定結果通知書今回終了日時, searchKey);
    }

    /**
     * サービス変更通知書のprocessパラメータを作成。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return ServiceHenkoTsutishoProcessParameter
     */
    public ServiceHenkoTsutishoProcessParameter toServiceHenkoTsutishoProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new ServiceHenkoTsutishoProcessParameter(発行日, 単票発行済み, 出力順, サービス変更通知書文書番号,
                サービス変更通知書今回開始日付, サービス変更通知書今回終了日付,
                サービス変更通知書今回開始日時, サービス変更通知書今回終了日時, searchKey);
    }

    /**
     * 要介護度変更通知書のprocessパラメータを作成。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @return YokaigoHenkoTsutishoProcessParameter
     */
    public YokaigoHenkoTsutishoProcessParameter toYokaigoHenkoTsutishoProcessParameter(IShikibetsuTaishoPSMSearchKey searchKey) {
        return new YokaigoHenkoTsutishoProcessParameter(発行日, 単票発行済み, 出力順, 要介護区分変更通知書文書番号,
                要介護区分変更通知書今回開始日付, 要介護区分変更通知書今回終了日付,
                要介護区分変更通知書今回開始日時, 要介護区分変更通知書今回終了日時, searchKey);
    }
}
