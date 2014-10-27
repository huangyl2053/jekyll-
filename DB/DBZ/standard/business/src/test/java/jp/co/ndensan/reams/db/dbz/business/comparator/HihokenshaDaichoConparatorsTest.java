/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.comparator;

import jp.co.ndensan.reams.db.dbz.model.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoConparators}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoConparatorsTest {

    public static class ShikakuShutokuDateComparator_compare extends DbzTestBase {
        //TODO #52997
        //資格取得日の降順で、HihokenshaDaichoModelのListがソートできることをテストしてください。
    }

}
