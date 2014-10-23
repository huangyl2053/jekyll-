/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.model;

import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShikakuShutokuKanrenJohoModel}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShikakuShutokuKanrenJohoModelTest {

    public static class constructor extends DbaTestBase {
        //TODO #52997
        //コンストラクタに渡される引数にnullが渡されたときに、NullPointerExceptionが発生するかをテストします。
        //1, 被保険者台帳ModelListにnullが渡されたとき
        //2, 医療保険加入状況ModelListにnullが渡されたとき
        //3, 生活保護ModelListにnullが渡されたとき
        //4, 老齢福祉ModelListにnullが渡されたとき
        //5, 施設入退所ModelListにnullが渡されたとき
    }
}
