/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.enkitsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.enkitsuchisho.EnkiTsuchishoJyohoMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD522001_延期通知書出力パラメタークラスです．
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EnkiTsuchishohakenIchiranhyoJyohoProcessParameter implements IBatchProcessParameter {

    private RString 画面モード;
    private FlexibleDate 処理見込み日From;
    private FlexibleDate 処理見込み日To;
    private List<FlexibleDate> 通知書発行日;
    private List<RString> 申請書管理番号リスト;
    private RString 文書番号;

    /**
     * コンストラクタです。
     *
     * @param gamenmodo 画面モード
     * @param shorimikomibiFrom 処理見込み日From
     * @param shorimikomibiTo 処理見込み日To
     * @param tsuchishohakkonbi 通知書発行日
     * @param shinseishokanribangorisuto 申請書管理番号リスト
     * @param bunshoBango 文書番号
     */
    public EnkiTsuchishohakenIchiranhyoJyohoProcessParameter(
            RString gamenmodo,
            FlexibleDate shorimikomibiFrom,
            FlexibleDate shorimikomibiTo,
            List<FlexibleDate> tsuchishohakkonbi,
            List<RString> shinseishokanribangorisuto,
            RString bunshoBango) {
        this.画面モード = gamenmodo;
        this.処理見込み日From = shorimikomibiFrom;
        this.処理見込み日To = shorimikomibiTo;
        this.通知書発行日 = tsuchishohakkonbi;
        this.申請書管理番号リスト = shinseishokanribangorisuto;
        this.文書番号 = bunshoBango;
    }

    /**
     * バーチのパラメータを作成します。
     *
     * @return EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter
     */
    public EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter toEnkiTsuchishohakenIchiranhyoJyohoMybatisParameter() {
        return new EnkiTsuchishohakenIchiranhyoJyohoMybatisParameter(処理見込み日From, 処理見込み日To, 通知書発行日.get(0), 文書番号);
    }

    /**
     * バーチのパラメータを作成します。
     *
     * @return EnkiTsuchishoJyohoMybatisParameter
     */
    public EnkiTsuchishoJyohoMybatisParameter toEnkiTsuchishoJyohoMybatisParameter() {
        return new EnkiTsuchishoJyohoMybatisParameter(申請書管理番号リスト,文書番号);
    }
}
