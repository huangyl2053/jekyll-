/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD210010;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付制限対象者一覧CSVのバッチパラメータの作成です。
 *
 * @reamsid_L DBD-4300-010 xuejm
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DBD210010_KyufuSeigenTaishoshaListParameter extends BatchParameterBase {

    private static final String ZENTOUROKUSHA = "zentourokusha";
    private static final String NIGOUSASHIYOKOTOUROKUSHA = "nigousashitomeyokotourokusha";
    private static final String NIGOUSASHITOUROKUSHA = "nigousashitometourokusha";
    private static final String YITIGOUSHOUKANYOKOTOUROKUSHA = "nigoushoukantomeyokotourokusha";
    private static final String YITIGOUSHOUKANKEITETOUROKUSHA = "nigoushoukantomekeitetourokusha";
    private static final String YITIGOUSHOUKANKEI_SASHIARI = "nigoushoukantomekei_sashiari";
    private static final String YITIGOUSHOUKANKEI_HOKENARI = "nigoushoukantomekei_hokenari";
    private static final String YITIGOUSKIFUTOUROKUSHA = "nigoukifutourokusha";
    private static final String OUTPUTJUNNID = "outputJunnId";
    private static final String KYUFUJOTAI = "kyufujotai";
    private static final String KIJUNYMD = "kijunYMD";

    @BatchParameter(key = ZENTOUROKUSHA, name = "全登録者")
    private boolean 全登録者;
    @BatchParameter(key = NIGOUSASHIYOKOTOUROKUSHA, name = "2号差止予告登録者")
    private boolean 二号差止予告登録者;
    @BatchParameter(key = NIGOUSASHITOUROKUSHA, name = "2号差止登録者")
    private boolean 二号差止登録者;
    @BatchParameter(key = YITIGOUSHOUKANYOKOTOUROKUSHA, name = "一号償還予告登録者")
    private boolean 一号償還予告登録者;
    @BatchParameter(key = YITIGOUSHOUKANKEITETOUROKUSHA, name = "一号償還決定登録者")
    private boolean 一号償還決定登録者;
    @BatchParameter(key = YITIGOUSHOUKANKEI_SASHIARI, name = "一号償還決定登録者_差止中あり")
    private boolean 一号償還決定登録者_差止中あり;
    @BatchParameter(key = YITIGOUSHOUKANKEI_HOKENARI, name = "一号償還決定登録者_保険料控除あり")
    private boolean 一号償還決定登録者_保険料控除あり;
    @BatchParameter(key = YITIGOUSKIFUTOUROKUSHA, name = "一号給付制限登録者")
    private boolean 一号給付制限登録者;
    @BatchParameter(key = OUTPUTJUNNID, name = "出力順設定リスト")
    private Long 出力順設定リスト;
    @BatchParameter(key = KYUFUJOTAI, name = "給付制限状態")
    private RString 給付制限状態;
    @BatchParameter(key = KIJUNYMD, name = "基準日")
    private RString 基準日;
}
