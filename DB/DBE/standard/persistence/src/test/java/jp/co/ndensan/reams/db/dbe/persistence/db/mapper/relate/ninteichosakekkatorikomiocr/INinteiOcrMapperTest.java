/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosakekkatorikomiocr;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosahyoEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link INinteiOcrMapper}のテストです。
 */
@RunWith(Enclosed.class)
public class INinteiOcrMapperTest extends DbeTestDacBase {

    public INinteiOcrMapperTest() {
    }

    public static void setUpClass() {
        DbeTestDacBase.beforeSetUpClass();
    }

    public static class Get関連データ {

        private RString 証記載保険者番号;
        private RString 申請書管理番号;
        private RString 認定申請日;

        @Before
        public void setUp() {
            証記載保険者番号 = new RString("202119");
            申請書管理番号 = new RString("0000241181");
            認定申請日 = new RString("20150501");
        }

        @Test
        public void testGet関連データ() {
            NinteiOcrMapperParamter param = NinteiOcrMapperParamter.createParamter(証記載保険者番号, 申請書管理番号, 認定申請日);
            INinteiOcrMapper sut = sqlSession.getMapper(INinteiOcrMapper.class);
            List<NinteiChosahyoEntity> list = sut.get認定調査票(param);
            NinteiChosahyoEntity entity = list.get(0);

            System.out.println(entity.get基本調査().size());
            System.out.println(entity.getサービスの状況().size());
            System.out.println(entity.getサービスの状況フラグ().size());
            System.out.println(entity.get記入項目().size());
            System.out.println(entity.get基本調査().isEmpty());
        }
    }
}
