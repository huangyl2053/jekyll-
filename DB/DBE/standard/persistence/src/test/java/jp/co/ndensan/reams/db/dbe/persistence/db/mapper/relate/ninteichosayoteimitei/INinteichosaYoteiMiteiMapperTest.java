/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosayoteimitei;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.chosahyoikenshochecklist.ChosahyoIkenshoCheckListParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyoikenshochecklist.ChosahyoIkenshoCheckListRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author n8179
 */
public class INinteichosaYoteiMiteiMapperTest extends DbeTestDacBase {

    private static INinteichosaYoteiMiteiMapper sut;

    @Before
    public void setUp() {
        sut = sqlSession.getMapper(INinteichosaYoteiMiteiMapper.class);
    }

    @Test
    public void get主治医意見書依頼未処理者情報_動作確認() {
        List<ChosahyoIkenshoCheckListRelateEntity> result = sut.getChosahyoIkenshoCheckList(create意見書依頼未処理者情報検索条件());
        System.out.println("チェックリスト対象者 件数：" + result.size());
        assertTrue(true);
    }

    private ChosahyoIkenshoCheckListParamter create意見書依頼未処理者情報検索条件() {
        RString 作成条件 = new RString("2");
        RString 申請日開始 = new RString("20010101");
        RString 申請日終了 = new RString("20170101");
        LasdecCode 市町村6 = new LasdecCode("206024");
        LasdecCode 市町村1 = new LasdecCode("202118");
        ChosahyoIkenshoCheckListParamter param = ChosahyoIkenshoCheckListParamter
                .createParamter(
                        申請日開始,
                        申請日終了,
                        RString.EMPTY,
                        RString.EMPTY,
                        作成条件,
                        市町村6);
        return param;
    }

}
