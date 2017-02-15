/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikekkatoroku;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikekkatoroku.ShinsakaiKekkaTorokuParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuDeletionCandidateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link IShinsakaiKekkaTorokuMapper}のテストです。
 */
@RunWith(Enclosed.class)
public class IShinsakaiKekkaTorokuMapperTest extends DbeTestDacBase {

    public IShinsakaiKekkaTorokuMapperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    public static class get関連情報 {

        @Test
        public void get関連情報() {
            IShinsakaiKekkaTorokuMapper sut = sqlSession.getMapper(IShinsakaiKekkaTorokuMapper.class);
            ShinsakaiKekkaTorokuParameter param = ShinsakaiKekkaTorokuParameter.createShinsakaiKekkaTorokuParameter(new RString("20100001"));
            for (ShinsakaiKekkaTorokuDeletionCandidateEntity o : sut.get削除候補s(param)) {
                System.out.println(o.getShinseishoKanriNo().value());
                System.out.println(o.getSharedFileID());
                if (o.getChosaIraiEntity() != null) {
                    System.out.print("　調査依頼：");
                    System.out.println(o.getChosaIraiEntity().getShinseishoKanriNo().value());
                }
                if (o.getIkenshoIraiEntity() != null) {
                    System.out.print("意見書依頼：");
                    System.out.println(o.getIkenshoIraiEntity().getShinseishoKanriNo().value());
                }
                if (o.getIchijiHanteiEntity() != null) {
                    System.out.print("　一次判定：");
                    System.out.println(o.getIchijiHanteiEntity().getShinseishoKanriNo().value());
                }
            }
        }
    }
}
