/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 世帯員把握テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SetaiShotokuEntity implements IDbAccessable {

    private RString kijunYMD;
    private RString jushochiTokureiFlag;
    private RString setaiCode;
    private RString honninKubun;
    private RString kazeiKubun;
    private RString kazeiKubunGemmenGo;
    private RString gekihenKanwaKubun;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private Decimal nenkiniShotokuGaku;
    private Decimal kazeiShotokuGaku;
    private RString torokuGyomu;
    private RString hihokenshaNo;
    private RString shikibetsuCode;
    private RString shotokuNendo;

}
