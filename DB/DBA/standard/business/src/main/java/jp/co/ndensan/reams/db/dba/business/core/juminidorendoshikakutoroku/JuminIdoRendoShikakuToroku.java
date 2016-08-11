/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.juminidorendoshikakutoroku;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民異動連動資格登録（資格変更）取得Businessクラスです。
 *
 * @reamsid_L DBA-1410-014 yaodongsheng
 */
public class JuminIdoRendoShikakuToroku {

    private static final RString 異動事由1号到達 = new RString("31");
    private static final RString 異動事由転居 = new RString("21");
    private static final RString 被保険者区分コード1号 = new RString("1");
    private static final RString 資格変更事由1号到達 = new RString("31");
    private static final RString 資格変更事由転居 = new RString("21");
    private static final int AGE = 65;

    /**
     * １号到達の被保険者台帳の編集です。
     *
     * @param 住民異動情報 住民異動情報
     * @param 被保険者台帳 被保険者台帳
     * @return 被保険者台帳Entity
     */
    public DbV1001HihokenshaDaichoEntity totatsu1go(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        IDateOfBirth dateofbirth = DateOfBirthFactory.createInstance(住民異動情報.getSeinengappiYMD());
        AgeCalculator agecalculator = new AgeCalculator(dateofbirth, JuminJotai.toValue(住民異動情報.getJuminJotaiCode()),
                住民異動情報.getShojoIdoYMD());
        FlexibleDate 年齢到達日 = agecalculator.get年齢到達日(AGE);
        被保険者台帳.setIdoYMD(住民異動情報.getIdoYMD());
        被保険者台帳.setEdaNo(RString.EMPTY);
        被保険者台帳.setIdoJiyuCode(異動事由1号到達);
        被保険者台帳.setIchigoShikakuShutokuYMD(年齢到達日);
        被保険者台帳.setHihokennshaKubunCode(被保険者区分コード1号);
        被保険者台帳.setShikakuHenkoJiyuCode(資格変更事由1号到達);
        被保険者台帳.setShikakuHenkoYMD(住民異動情報.getIdoYMD());
        被保険者台帳.setShikakuHenkoTodokedeYMD(住民異動情報.getTodokedeYMD());
        被保険者台帳.setLogicalDeletedFlag(false);
        return 被保険者台帳;
    }

    /**
     * 転居の被保険者台帳の編集です。
     *
     * @param 住民異動情報 住民異動情報
     * @param 被保険者台帳 被保険者台帳
     * @return 被保険者台帳Entity
     */
    public DbV1001HihokenshaDaichoEntity tenkyo(UaFt200FindShikibetsuTaishoEntity 住民異動情報, DbV1001HihokenshaDaichoEntity 被保険者台帳) {
        IDateOfBirth dateofbirth = DateOfBirthFactory.createInstance(住民異動情報.getSeinengappiYMD());
        AgeCalculator agecalculator = new AgeCalculator(dateofbirth, JuminJotai.toValue(住民異動情報.getJuminJotaiCode()),
                住民異動情報.getShojoIdoYMD());
        FlexibleDate 年齢到達日 = agecalculator.get年齢到達日(AGE);
        被保険者台帳.setIdoYMD(住民異動情報.getIdoYMD());
        被保険者台帳.setEdaNo(RString.EMPTY);
        被保険者台帳.setIdoJiyuCode(異動事由転居);
        被保険者台帳.setIchigoShikakuShutokuYMD(年齢到達日);
        被保険者台帳.setShikakuHenkoJiyuCode(資格変更事由転居);
        被保険者台帳.setShikakuHenkoYMD(住民異動情報.getIdoYMD());
        被保険者台帳.setShikakuHenkoTodokedeYMD(住民異動情報.getTodokedeYMD());
        被保険者台帳.setLogicalDeletedFlag(false);
        return 被保険者台帳;
    }
}
