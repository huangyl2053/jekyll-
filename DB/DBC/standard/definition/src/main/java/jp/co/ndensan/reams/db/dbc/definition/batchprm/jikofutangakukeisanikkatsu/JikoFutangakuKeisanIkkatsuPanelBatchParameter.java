/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.jikofutangakukeisanikkatsu;

import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBCMNN1001_事業高額合算・事業分自己負担額計算（括）のクラスです。
 *
 * @reamsid_L DBC-4790-010 chenyadong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")

public class JikoFutangakuKeisanIkkatsuPanelBatchParameter extends BatchParameterBase {

    private static final String KEY_SHORITIME = "shoriTime";
    private static final String KEY_UKETORIYM = "uketoriym";
    private static final String KEY_HIHOKENSHANO = "hihokenshano";
    private static final String KEY_NENDO = "nendo";
    private static final String KEY_RADSAKUSEIJOKEN = "radSakuseiJoken";
    private static final String KEY_SHUTURYOKUFLG = "shuturyokuFlg";
    private static final String KEY_SHUTSURYOKUJUNID = "shutsuryokujunId";
    private static final String KEY_DANTAICD = "dantaiCd";

    @BatchParameter(key = KEY_SHORITIME, name = "処理日時")
    private RString shoriTime;
    @BatchParameter(key = KEY_UKETORIYM, name = "受取年月")
    private FlexibleYearMonth uketoriym;
    @BatchParameter(key = KEY_HIHOKENSHANO, name = "被保険者番号")
    private RString hihokenshano;
    @BatchParameter(key = KEY_NENDO, name = "年度")
    private RString nendo;
    @BatchParameter(key = KEY_RADSAKUSEIJOKEN, name = "出力対象区分")
    private RString radSakuseiJoken;
    @BatchParameter(key = KEY_SHUTURYOKUFLG, name = "出力フラグ")
    private boolean shuturyokuFlg;
    @BatchParameter(key = KEY_SHUTSURYOKUJUNID, name = "帳票出力順ID")
    private Long shutsuryokujunId;
    @BatchParameter(key = KEY_DANTAICD, name = "市町村コード")
    private Association dantaiCd;
}
