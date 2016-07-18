/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 高額総合事業サービス費対象者一覧表Editor
 *
 * @reamsid_L DBC-2010-120 surun
 */
public class KogakuSogoJigyoServiceHiTaishoshaIchiranEditor implements IKogakuSogoJigyoServiceHiTaishoshaIchiranEditor {

    private static final RString SAKUSEI = new RString("作成");
    private static final RString 単独合算 = new RString("単");
    private final KogakuSogoJigyoServiceHiTaishoshaIchiranEntity 高額総合事業サービス費対象者一覧表;
    private final YMDHMS システム日時;
    private final Association association;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final int 連番;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;

    /**
     *
     * @param 高額総合事業サービス費対象者一覧表 KogakuSogoJigyoServiceHiTaishoshaIchiranEntity
     * @param システム日時 YMDHMS
     * @param association Association
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 連番 int
     */
    public KogakuSogoJigyoServiceHiTaishoshaIchiranEditor(KogakuSogoJigyoServiceHiTaishoshaIchiranEntity 高額総合事業サービス費対象者一覧表,
            YMDHMS システム日時,
            Association association,
            List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト,
            int 連番) {
        this.高額総合事業サービス費対象者一覧表 = 高額総合事業サービス費対象者一覧表;
        this.システム日時 = システム日時;
        this.association = association;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.連番 = 連番;
    }

    /**
     * edit
     *
     * @param source KogakuSogoJigyoServiceHiTaishoshaIchiranSource
     * @return KogakuSogoJigyoServiceHiTaishoshaIchiranSource
     */
    @Override
    public KogakuSogoJigyoServiceHiTaishoshaIchiranSource edit(KogakuSogoJigyoServiceHiTaishoshaIchiranSource source) {
        if (システム日時 != null && !システム日時.isEmpty()) {
            RString システム日 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString システム時 = システム日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = システム日.concat(RString.HALF_SPACE).concat(システム時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        }
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.get審査年月From() != null) {
            source.shinsaYMKaishi = 高額総合事業サービス費対象者一覧表.get審査年月From().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.get審査年月To() != null) {
            source.shinsaYMShuryo = 高額総合事業サービス費対象者一覧表.get審査年月To().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.get市町村コード() != null) {
            source.hokenshaNo = 高額総合事業サービス費対象者一覧表.get市町村コード().getColumnValue();
        }
        if (association != null) {
            source.hokenshaName = association.get市町村名();
        }
        set出力改頁(source);
        source.listTaishoshaIchiran_1 = new RString(連番);
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.get被保険者番号() != null) {
            source.listTaishoshaIchiran_2 = 高額総合事業サービス費対象者一覧表.get被保険者番号().getColumnValue();
        }
        //TODO 識別コード QA(#948)
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.getサービス提供年月() != null) {
            source.listTaishoshaIchiran_3 = 高額総合事業サービス費対象者一覧表.getサービス提供年月().toDateString();
        }
        付値(source);
        return source;
    }

    /**
     * set出力改頁
     *
     * @param source KogakuSogoJigyoServiceHiTaishoshaIchiranSource
     */
    private void set出力改頁(KogakuSogoJigyoServiceHiTaishoshaIchiranSource source) {
        if (NUM0 < 出力項目リスト.size()) {
            source.shutsuryokujun1 = 出力項目リスト.get(NUM0);
            if (NUM0 < 改頁項目リスト.size()) {
                source.kaipage1 = 改頁項目リスト.get(NUM0);
            }
        }
        if (NUM1 < 出力項目リスト.size()) {
            source.shutsuryokujun2 = 出力項目リスト.get(NUM1);
            if (NUM1 < 改頁項目リスト.size()) {
                source.kaipage2 = 改頁項目リスト.get(NUM1);
            }
        }
        if (NUM2 < 出力項目リスト.size()) {
            source.shutsuryokujun3 = 出力項目リスト.get(NUM2);
            if (NUM2 < 改頁項目リスト.size()) {
                source.kaipage3 = 改頁項目リスト.get(NUM2);
            }
        }
        if (NUM3 < 出力項目リスト.size()) {
            source.shutsuryokujun4 = 出力項目リスト.get(NUM3);
            if (NUM3 < 改頁項目リスト.size()) {
                source.kaipage4 = 改頁項目リスト.get(NUM3);
            }
        }
        if (NUM4 < 出力項目リスト.size()) {
            source.shutsuryokujun5 = 出力項目リスト.get(NUM4);
            if (NUM4 < 改頁項目リスト.size()) {
                source.kaipage5 = 改頁項目リスト.get(NUM4);
            }
        }
    }

    /**
     * 付値
     *
     * @param source KogakuSogoJigyoServiceHiTaishoshaIchiranSource
     */
    private void 付値(KogakuSogoJigyoServiceHiTaishoshaIchiranSource source) {
        if (高額総合事業サービス費対象者一覧表 != null) {
            source.listTaishoshaIchiran_4 = 高額総合事業サービス費対象者一覧表.get被保険者名();
        }
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.get要介護認定状態区分コード() != null) {
            RString 要介護認定状態区分コード = 高額総合事業サービス費対象者一覧表.get要介護認定状態区分コード().getColumnValue();
            source.listTaishoshaIchiran_5 = new RString(YoKaigoJotaiKubun.toValue(要介護認定状態区分コード).name());
        }
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.get世帯コード() != null) {
            source.listTaishoshaIchiran_6 = 高額総合事業サービス費対象者一覧表.get世帯コード().getColumnValue();
        }
        source.listTaishoshaIchiran_7 = 単独合算;
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.get利用者負担額() != null) {
            source.listTaishoshaIchiran_8 = new RString(高額総合事業サービス費対象者一覧表.get利用者負担額().toString());
        }
        if (高額総合事業サービス費対象者一覧表 != null && 高額総合事業サービス費対象者一覧表.get支給予定金額() != null) {
            source.listTaishoshaIchiran_9 = new RString(高額総合事業サービス費対象者一覧表.get支給予定金額().toString());
        }
        if (高額総合事業サービス費対象者一覧表 != null) {
            source.listTaishoshaIchiran_11 = 高額総合事業サービス費対象者一覧表.get備考();
        }
    }

}
