/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd8100202;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.ChofukuTorikomiDataDeleteShoriProcessParmeter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.HikazeNenkinTaishoFirProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.JissekiDataIchijiSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.ShimeiKanaTotsugoGaitousyaNasiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.ShimeiKanaTotsugoSedProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd8100202.ShimeiKanaTotsugoTouItuninProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者同定バッチパラメタークラスです．
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HikazeNenkinTaishoshaDouteiBatchParameter extends BatchParameterBase {

    private FlexibleYear 年度;
    private RString 処理区分;
    private RString 対象月;

    /**
     * 対象者一次特定の引数を返します。
     *
     * @return 対象者一次特定の引数
     */
    public JissekiDataIchijiSakuseiProcessParamter toJissekiDataIchijiSakuseiProcessParamter() {
        return new JissekiDataIchijiSakuseiProcessParamter();
    }

    /**
     * 年金番号突合_非課税年金対象者情報１_登録のパラメターを返却します．
     *
     * @return 年金番号突合_非課税年金対象者情報１_登録のパラメター
     */
    public HikazeNenkinTaishoFirProcessParameter toHikazeNenkinTaishoFirProcessParameter() {
        return new HikazeNenkinTaishoFirProcessParameter(年度, 処理区分, 対象月);
    }

    /**
     * 重複取込データ除外処理_processのパラメターをします．
     *
     * @return 非課税年金対象者同定のパラメター
     */
    public ChofukuTorikomiDataDeleteShoriProcessParmeter toChofukuTorikomiDataDeleteShoriProcessParmeter() {
        return new ChofukuTorikomiDataDeleteShoriProcessParmeter(年度, 処理区分, 対象月);
    }

    /**
     * 氏名カナ突合_該当者なし情報_登録のパラメターを返却します．
     *
     * @return 氏名カナ突合_該当者なし情報_登録の
     */
    public ShimeiKanaTotsugoGaitousyaNasiProcessParameter toShimeiKanaTotsugoGaitousyaNasiProcessParameter() {
        return new ShimeiKanaTotsugoGaitousyaNasiProcessParameter(年度, 処理区分, 対象月);
    }

    /**
     * 氏名カナ突合_非課税年金対象者情報２_登録情報のパラメターを返却します．
     *
     * @return 氏名カナ突合_非課税年金対象者情報２_登録情報のパラメター
     */
    public ShimeiKanaTotsugoSedProcessParameter toShimeiKanaTotsugoSedProcessParameter() {
        return new ShimeiKanaTotsugoSedProcessParameter(年度, 処理区分, 対象月);
    }

    /**
     * 氏名カナ突合_同一人情報_登録のパラメターを返却します．
     *
     * @return 氏名カナ突合_同一人情報_登録のパラメター
     */
    public ShimeiKanaTotsugoTouItuninProcessParameter toShimeiKanaTotsugoTouItuninProcessParameter() {
        return new ShimeiKanaTotsugoTouItuninProcessParameter(年度, 処理区分, 対象月);
    }
}
