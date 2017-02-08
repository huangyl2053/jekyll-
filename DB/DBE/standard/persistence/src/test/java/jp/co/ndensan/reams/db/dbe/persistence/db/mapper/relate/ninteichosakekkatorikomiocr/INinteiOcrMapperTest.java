/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosakekkatorikomiocr;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.ChosahyoOcrContextParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaContextEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaKekkaTorikomiOcrRelateEntity;
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
        public void get関連データ() {
            NinteiOcrMapperParamter param = NinteiOcrMapperParamter.createParamter(証記載保険者番号, 申請書管理番号, 認定申請日);
            INinteiOcrMapper sut = sqlSession.getMapper(INinteiOcrMapper.class);

            List<NinteiChosaKekkaTorikomiOcrRelateEntity> list = sut.get関連データ(param);
            NinteiChosaKekkaTorikomiOcrRelateEntity entity = list.get(0);
            System.out.println(entity.get被保険者氏名());
            System.out.println(entity.is論理削除フラグ());
            System.out.println(entity.isMatches指定申請日());
            System.out.println(entity.get認定調査依頼日().wareki().toDateString());
        }

        @Test
        public void find調査員() {
            ChosahyoOcrContextParameter param = new ChosahyoOcrContextParameter(new RString("00000020161200002"), new RString("0000000035"), new RString("00000001"));
            INinteiOcrMapper sut = sqlSession.getMapper(INinteiOcrMapper.class);
            NinteiChosaContextEntity entity = sut.getNinteiChosaContext(param);
            System.out.println("調査員　　存在:");
            System.out.println(entity.getExists調査員区分());

            ChosahyoOcrContextParameter param2 = new ChosahyoOcrContextParameter(new RString("00000020161200002"), new RString("0000000035"), new RString("01000033"));
            entity = sut.getNinteiChosaContext(param2);
            System.out.println("調査員　不存在:");
            System.out.println(entity.getExists調査員区分());

            ChosahyoOcrContextParameter param3 = new ChosahyoOcrContextParameter(new RString("00000020161200002"), new RString("0990000003"), new RString("00000033"));
            entity = sut.getNinteiChosaContext(param3);
            System.out.println("委託先　不存在:");
            System.out.println(entity.getExists調査員区分());
        }

        @Test
        public void get認定調査票() {
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
