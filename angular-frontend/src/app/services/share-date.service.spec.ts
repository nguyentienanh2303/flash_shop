import { TestBed } from '@angular/core/testing';

import { ShareDateService } from './share-date.service';

describe('ShareDateService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ShareDateService = TestBed.get(ShareDateService);
    expect(service).toBeTruthy();
  });
});
