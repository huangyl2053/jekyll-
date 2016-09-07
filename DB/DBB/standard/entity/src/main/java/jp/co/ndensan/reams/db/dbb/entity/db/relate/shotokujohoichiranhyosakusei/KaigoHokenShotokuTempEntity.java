/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 介護保険所得Temp
 *
 * @reamsid_L DBB-1650-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShotokuTempEntity implements IDbAccessable {

    private static final RString INDEX_22 = new RString("22");

    private ShikibetsuCode shikibetsuCode;
    private HihokenshaNo hihokenshaNo;
    private AtenaKanaMeisho kanaMeisho;
    private AtenaMeisho meisho;
    private FlexibleYear shotokuNendo;
    private FlexibleDate seinengappiYMD;
    private RString shojoJiyuCode;
    private FlexibleDate shojoIdoYMD;
    private int age;
    private RString seibetsuCode;
    private RString juminShubetsuCode;
    private RString kazeiKubun;
    private RString kazeiKubunGemmenGo;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private Decimal nenkiniShotokuGaku;
    private Decimal kazeiShotokuGaku;
    private RString torokuGyomu;

    /**
     * 介護保険所得を作成します。
     *
     * @param temp KaigoHokenShotokuTempEntity
     * @return KaigoHokenShotokuTempEntity
     */
    public KaigoHokenShotokuTempEntity toKaigoHokenShotokuTempEntity(KaigoHokenShotokuTempEntity temp) {
        KaigoHokenShotokuTempEntity entity = new KaigoHokenShotokuTempEntity();
        entity.setShikibetsuCode(temp.getShikibetsuCode());
        entity.setHihokenshaNo(temp.getHihokenshaNo());
        entity.setKanaMeisho(temp.getKanaMeisho());
        entity.setMeisho(temp.getMeisho());
        entity.setShotokuNendo(temp.getShotokuNendo());
        entity.setSeinengappiYMD(temp.getSeinengappiYMD());
        entity.setShojoJiyuCode(temp.getShojoJiyuCode());
        entity.setShojoIdoYMD(temp.getShojoIdoYMD());
        RString 消除事由コード = temp.getShojoJiyuCode();
        FlexibleDate 生年月日 = temp.getSeinengappiYMD();
        if (生年月日 != null) {
            if (INDEX_22.equals(消除事由コード)) {
                FlexibleDate 消除異動年月日 = temp.getShojoIdoYMD();
                int 年齢 = 消除異動年月日.getYearValue() - 生年月日.getYearValue();
                entity.setAge(年齢);
            } else {
                int システム年 = FlexibleDate.getNowDate().getYearValue();
                int 年齢 = システム年 - 生年月日.getYearValue();
                entity.setAge(年齢);
            }
        }
        entity.setSeibetsuCode(temp.getSeibetsuCode());
        entity.setJuminShubetsuCode(temp.getJuminShubetsuCode());
        entity.setKazeiKubun(temp.getKazeiKubun());
        entity.setKazeiKubunGemmenGo(temp.getKazeiKubunGemmenGo());
        entity.setGokeiShotokuGaku(temp.getGokeiShotokuGaku());
        entity.setNenkiniShunyuGaku(temp.getNenkiniShunyuGaku());
        entity.setNenkiniShotokuGaku(temp.getNenkiniShotokuGaku());
        entity.setKazeiShotokuGaku(temp.getKazeiShotokuGaku());
        entity.setTorokuGyomu(temp.getTorokuGyomu());
        return entity;
    }
}
